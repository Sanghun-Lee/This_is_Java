package io_18.assistant.buffered;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * BufferedInputStream이 있을때와 없을때의 속도 차이 비교
 */

public class BufferedInputStreamExample {
    private String path = BufferedInputStreamExample.class.getResource("forest.jpg").getPath();

    public static void main(String[] args) throws Exception {
        long start = 0;
        long end = 0;

        BufferedInputStreamExample obj = new BufferedInputStreamExample();

        System.out.println("path : " + obj.path);

        FileInputStream fileInputStream1 = new FileInputStream(obj.path);
        start = System.currentTimeMillis();
        // BufferedInputStream 없이 시간 측정
        while(fileInputStream1.read() != -1) {}
        end = System.currentTimeMillis();
        System.out.println("사용하지 않았을 때 : " + (end - start) + "ms");
        fileInputStream1.close();

        FileInputStream fileInputStream2 = new FileInputStream(obj.path);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream2);
        start = System.currentTimeMillis();
        while(bufferedInputStream.read() != -1) {}
        end = System.currentTimeMillis();

        System.out.println("사용했을 때 : " + (end - start) + "ms");
        bufferedInputStream.close();
        fileInputStream2.close();

    }
}
