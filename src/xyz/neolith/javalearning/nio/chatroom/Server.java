package xyz.neolith.javalearning.nio.chatroom;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * chat room server
 * @author sunlggggg
 */
public class Server {
    private Selector selector = null;
    private static final int port = 9999;
    private Charset charset = Charset.forName("UTF-8");

    //thread-safe
    private Set<String> userNames = Collections.synchronizedSet(new HashSet<>());

    private void init() throws IOException {
        selector = Selector.open();//use to manage multiple channels

        ServerSocketChannel server = ServerSocketChannel.open();
        server.bind(new InetSocketAddress(port));
        server.configureBlocking(false);//no blocking

        server.register(selector, SelectionKey.OP_ACCEPT);//when the channel accept the connect

        System.out.println("Server is listening now...");

        //noinspection InfiniteLoopStatement
        while (true) {
            int readyChannels = selector.select();
            if (readyChannels == 0) continue;
            //selectedKey   A token representing the registration of SelectableChannel with a Selector
            Set selectedKeys = selector.selectedKeys();  // SelectionKey.OP_ACCEPT
            Iterator keyIterator = selectedKeys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey sk = (SelectionKey) keyIterator.next();
                keyIterator.remove();
                dealWithSelectionKey(server, sk);
            }
        }
    }

    private void dealWithSelectionKey(ServerSocketChannel server, SelectionKey sk) throws IOException {
        if (sk.isAcceptable()) {
            SocketChannel sc = server.accept();
            //no blocking
            sc.configureBlocking(false);
            //注册选择器，并设置为读取模式，收到一个连接请求，然后起一个SocketChannel，
            //并注册到selector上，之后这个连接的数据，就由这个SocketChannel处理
            sc.register(selector, SelectionKey.OP_READ);

            //将此对应的channel设置为准备接受其他客户端请求
            sk.interestOps(SelectionKey.OP_ACCEPT);
            System.out.println("Server is listening from client :" + sc.getRemoteAddress());
            sc.write(charset.encode("Please input your name."));
        }
        //处理来自客户端的数据读取请求
        if (sk.isReadable()) {
            //返回该SelectionKey对应的 Channel，其中有数据需要读取
            SocketChannel sc = (SocketChannel) sk.channel();
            ByteBuffer buff = ByteBuffer.allocate(1024);
            StringBuilder content = new StringBuilder();
            try {
                while (sc.read(buff) > 0) {
                    buff.flip();
                    content.append(charset.decode(buff));

                }
                System.out.println("Server is listening from client " + sc.getRemoteAddress() + " data rev is: " + content);
                //将此对应的channel设置为准备下一次接受数据
                sk.interestOps(SelectionKey.OP_READ);
            } catch (IOException io) {
                sk.cancel();
                if (sk.channel() != null) {
                    sk.channel().close();
                }
            }
            if (content.length() > 0) {
                String USER_CONTENT_SPLIT = "#@#";
                String[] arrayContent = content.toString().split(USER_CONTENT_SPLIT);
                //注册用户
                if (arrayContent.length == 1) {
                    String name = arrayContent[0];
                    if (userNames.contains(name)) {
                        String USER_EXIST = "system message: user exist, please change a name";
                        sc.write(charset.encode(USER_EXIST));

                    } else {
                        userNames.add(name);
                        int num = OnlineNum(selector);
                        String message = "welcome " + name + " to chat room! Online numbers:" + num;
                        BroadCast(selector, null, message);
                    }
                }
                //注册完了，发送消息
                else if (arrayContent.length > 1) {
                    String name = arrayContent[0];
                    String message = content.substring(name.length() + USER_CONTENT_SPLIT.length());
                    message = name + " say:" + message;
                    if (userNames.contains(name)) {
                        //不回发给发送此内容的客户端
                        BroadCast(selector, sc, message);
                    }
                }
            }

        }
    }

    private static int OnlineNum(Selector selector) {
        int res = 0;
        for (SelectionKey key : selector.keys()) {
            Channel targetChannel = key.channel();
            if (targetChannel instanceof SocketChannel) {
                res++;
            }
        }
        return res;
    }

    private void BroadCast(Selector selector, SocketChannel except, String content) throws IOException {
        //广播数据到所有的SocketChannel中
        for (SelectionKey key : selector.keys()) {
            Channel targetChannel = key.channel();
            //如果except不为空，不回发给发送此内容的客户端
            if (targetChannel instanceof SocketChannel && targetChannel != except) {
                SocketChannel dest = (SocketChannel) targetChannel;
                dest.write(charset.encode(content));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Server().init();
    }
}
