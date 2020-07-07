package io_18.console.system_in;

import java.io.InputStream;

public class SystemInExample1 {
    public static void main(String[] args) throws Exception {
        System.out.println("=== 메뉴 ===");
        System.out.println("1. 예금 조회");
        System.out.println("2. 예금 출금");
        System.out.println("3. 예금 입금");
        System.out.println("4. 종료 하기");
        System.out.println("메뉴를 선택하세요");

        InputStream inputStream = System.in;

        char inputData = (char) inputStream.read();

        switch (inputData) {
            case '1':
                System.out.println("예금 조회를 선택하셨습니다.");
                break;
            case '2':
                System.out.println("예금 출금을 선택하셨습니다.");
                break;
            case '3':
                System.out.println("예금 입금을 선택하셨습니다.");
                break;
            case '4':
                System.out.println("종료 하기를 선택하셨습니다.");
                break;
        }
    }
}
