package api_11.string;

// 키보드에서 입력받은 문자열을 String 으로 저장하기
// 키보드에서 입력받으면 마지막에 \r 캐리지 리턴, \n 개행문자 이렇게 2개가 뒤에 더 붙게 된다.
// 그래서 그 2개를 빼고 나머지를 String type 필드에 넣는다.

import java.io.IOException;

public class KeyboardToStringExample {
    public static void main(String[] args) {
        byte[] bytes = new byte[100];       // 읽은 바이트를 저장하기 위한 배열 생성

        System.out.print("입력 : ");
        try {
            int readByteNo = System.in.read(bytes); // 배열에 읽은 바이트를 저장하고 읽은 바이트 수를 리턴
            String str = new String(bytes, 0, readByteNo - 2);  // 배열을 문자열로 저장
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
