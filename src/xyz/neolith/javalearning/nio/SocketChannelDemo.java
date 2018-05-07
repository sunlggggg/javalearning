package xyz.neolith.javalearning.nio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class SocketChannelDemo {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        //use the node start a serve
        //node/socketServer.js
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 80));
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();
        inChannel.read(byteBuffer);
        socketChannel.write(byteBuffer);
    }
}
