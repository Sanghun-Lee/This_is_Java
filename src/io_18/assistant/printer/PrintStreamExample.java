package io_18.assistant.printer;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamExample {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("/home/hun/test.txt");
        PrintStream printStream = new PrintStream(fos);

        printStream.println("[프린터 보조 스트림]");
        printStream.print("마치 ");
        printStream.println("프린터가 출력하는 것처럼 ");
        printStream.println("데이터를 출력합니다.");

        printStream.flush();
        printStream.close();
        fos.close();
    }
}
