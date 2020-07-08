package io_18.assistant.to_char;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamReaderExample {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader reader = new InputStreamReader(inputStream);

        int readCharNo;
        char[] cbuf = new char[100];

        while( (readCharNo = reader.read(cbuf)) != -1) {
            String str = new String(cbuf, 0, readCharNo);
            System.out.println(str);
        }

        reader.close();
    }
}
