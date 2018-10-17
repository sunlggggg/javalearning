package com.github.sunlggggg.javalearning.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public class BufferDemo {
    private static ByteBuffer buffer;

    private static void val() {
        System.out.println("capacity: " + buffer.capacity());
        System.out.println("limit: " + buffer.limit());
        System.out.println("position: " + buffer.position());
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
        buffer = ByteBuffer.allocate(48);
        val();
//        capacity: 48
//        limit: 48
//        position: 0

        val();
//        capacity: 48
//        limit: 48
//        position: 48

        //throws java.nio.BufferUnderflowException, because the position(48) equals to limit(48) , we can not read the data from the buffer
        //System.out.println(buffer.get());


        buffer.flip();
        val();
//        capacity: 48
//        limit: 48
//        position: 0


//        public final boolean hasRemaining() {
//            return position < limit;
//        }
        while (buffer.hasRemaining()) {
            System.out.println((char) buffer.get());
        }
        try {
            aFile.close();
        } catch(IOException e ){
        }
    }
}
