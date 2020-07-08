package io_18.file.reader_writer;

import java.io.File;
import java.io.FileWriter;

public class FileWriterExample {
    public static void main(String[] args) throws Exception {
        File file = new File("/home/hun/fileWriter.txt");
        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write("FileWriter는 한글로 된 " + "\r\n");
        fileWriter.write("문자열을 바로 출력할 수 있다." + "\r\n");
        fileWriter.flush();
        fileWriter.close();
        System.out.println("파일이 저장되었습니다.");
    }
}
