package io_18.assistant.buffered;

import java.io.*;

public class BufferedOutputStreamExample {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        int data = -1;
        long start = 0, end = 0;

        // BufferedOutputStream 없이 사진 복사
        fileInputStream = new FileInputStream("forest.jpg");
        bufferedInputStream = new BufferedInputStream(fileInputStream);

        fileOutputStream = new FileOutputStream("/home/hun/forest.jpg");

        start = System.currentTimeMillis();
        while( (data = bufferedInputStream.read()) != -1) {
            fileOutputStream.write(data);
        }

        fileOutputStream.flush();
        end = System.currentTimeMillis();
        fileOutputStream.close();
        bufferedInputStream.close();
        fileInputStream.close();
        System.out.println("사용하지 않을 때 : " + (end - start) + "ms");


        fileInputStream = new FileInputStream("forest.jpg");
        bufferedInputStream = new BufferedInputStream(fileInputStream);

        fileOutputStream = new FileOutputStream("/home/hun/forest.jpg");
        bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        start = System.currentTimeMillis();
        while( (data = bufferedInputStream.read()) != -1) {
            bufferedOutputStream.write(data);
        }

        bufferedOutputStream.flush();
        end = System.currentTimeMillis();
        bufferedOutputStream.close();
        fileOutputStream.close();
        fileInputStream.close();
        System.out.println("사용했을 때 : " + (end - start) + "ms");
    }
}
