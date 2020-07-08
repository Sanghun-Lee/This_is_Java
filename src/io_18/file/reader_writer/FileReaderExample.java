package io_18.file.reader_writer;

import java.io.FileReader;

public class FileReaderExample {
    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader("/home/hun/네트워크 7강.txt");

        int readCharNo;

        char[] cbuf = new char[100];
        while( (readCharNo = fileReader.read(cbuf)) != -1 ) {
            String data = new String(cbuf, 0, readCharNo);
            System.out.print(data);
        }
        fileReader.close();
    }
}
