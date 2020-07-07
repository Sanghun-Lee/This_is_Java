package io_18.file.io_stream;

import java.io.FileInputStream;

public class FileInputStreamExample {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("/home/hun/네트워크 5강");
            int data = 0;

            while ((data = fileInputStream.read()) != -1)
                System.out.write(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
