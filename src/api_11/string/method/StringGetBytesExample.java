package api_11.string.method;

// String 을 byte 배열로 변환
// "문자열".getBytes();
// "문자열".getBytes(Charset charset);

// 디코딩 하는 방법도 charset 에 맞게 해야된다.
// EUC-KR   : 영어 1byte, 한글 : 2byte
// UTF-8    : 영어 1byte, 한글 : 3byte

import java.io.UnsupportedEncodingException;

public class StringGetBytesExample {
    public static void main(String[] args) {
        String str = "안녕하세요";

        byte[] bytes1 = str.getBytes();         // 인코딩
        System.out.println("bytes1.length : " + bytes1.length);
        String str1 = new String(bytes1);       // 디코딩
        System.out.println("bytes1 -> String : " + str1);

        try {
            // EUC-KR 을 이용해서 인코딩 및 디코딩
            byte[] bytes2 = str.getBytes("EUC-KR");     // EUC-KR을 이용해서 인코딩
            System.out.println("bytes2.length : " + bytes2.length);
            String str2 = new String(bytes2, "EUC-KR"); // 디코딩
            System.out.println("bytes2 -> String : " + str2);

            // UTF-8을 이용해서 인코딩 및 디코딩
            byte[] bytes3 = str.getBytes("UTF-8");
            System.out.println("bytes3.length : " + bytes3.length);
            String str3 = new String(bytes3, "UTF-8");
            System.out.println("bytes3 -> String : " + str3);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
