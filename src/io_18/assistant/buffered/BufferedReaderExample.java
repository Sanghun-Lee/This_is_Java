package io_18.assistant.buffered;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class BufferedReaderExample {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);

        System.out.print("입력 : ");
        String lineString = bufferedReader.readLine();

        System.out.println("출력 : " + lineString);
    }
}
