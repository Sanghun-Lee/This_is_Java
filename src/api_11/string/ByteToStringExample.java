package api_11.string;

// byte 배열을 문자열로 변환해 보자.
// byte 배열 전체를 String 객체로 생성 - String str = new String(byte[] bytes);

// 다양한 형태로 String 객체 생성
// 지정한 문자셋으로 인코딩
//  - String str = new String(byte[] bytes, String charsetName);
// 배열의 offset 인덱스 위치부터 length 만큼 String 객체로 생성
//  - String str = new String(byte[] bytes, int offset, int length);
// 지정한 문자셋으로 디코딩
//  - String str = new String(byte[] bytes, int offset, int length, String charsetName);

public class ByteToStringExample {
    public static void main(String[] args) {
        byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97 }; // Hello Java

        String str1 = new String(bytes);
        System.out.println(str1);

        String str2 = new String(bytes, 6, 4);  // 6번지 (74값)부터 4개 잘라서 생성
        System.out.println(str2);
    }
}
