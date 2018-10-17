package com.github.sunlggggg.javalearning.nio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.*;

public class ChannelDemo {

    @Test
    public void testChannel() {

        try(RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
            FileChannel inChannel = aFile.getChannel()){
            ByteBuffer buf = ByteBuffer.allocate(48);

            int bytesRead = inChannel.read(buf);
            while (bytesRead != -1) {
                System.out.println("\tRead " + bytesRead);
                buf.flip();//convert the write mode to read mode
                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());
                }
                buf.clear();
                bytesRead = inChannel.read(buf);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * scatter: one channel data to multiple buffers
     * gather: multiple buffers into one channel
     */
    @Test
    public void testScatterAndGather() throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();
        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body   = ByteBuffer.allocate(1024);

        ByteBuffer[] bufferArray = { header, body };

        //scatter
        inChannel.read(bufferArray);

        for(ByteBuffer byteBuffer : bufferArray){
            byteBuffer.flip();
        }

        //gather
        RandomAccessFile outFile = new RandomAccessFile("data/nio-out.txt", "rw");
        FileChannel outChannel = outFile.getChannel();
        outChannel.write(bufferArray);
        outChannel.force(true);
        try {
            outFile.close();
        } catch (IOException e ){
            
        }
        try {
            aFile.close();
        } catch (IOException e ){
            
        }
    }
}
