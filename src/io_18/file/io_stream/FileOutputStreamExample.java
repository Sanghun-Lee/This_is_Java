package io_18.file.io_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOutputStreamExample {
    public static void main(String[] args) throws Exception {
        String originalFileName = "/home/hun/Pictures/1.png";
        String targetFileName = "/home/hun/Pictures/1_copy.png";

        FileInputStream fileInputStream = new FileInputStream(originalFileName);
        FileOutputStream fileOutputStream = new FileOutputStream(targetFileName);

        int readByteNo;
        byte[] readBytes = new byte[100];

        while( (readByteNo = fileInputStream.read(readBytes)) != -1) {
            fileOutputStream.write(readBytes, 0, readByteNo);
        }

        fileOutputStream.flush();
        fileOutputStream.close();
        fileInputStream.close();

        System.out.println("복사가 잘 되었습니다.");
    }
}
