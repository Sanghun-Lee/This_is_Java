package api_11.string.method;

// length 메소드 / 필드는 배열일 때
// 설명 생략

public class StringLengthExample {
    public static void main(String[] args) {
        String ssn = "1234567890123";
        int length = ssn.length();

        if(length == 13) {
            System.out.println("주민등록번호 자릿수가 맞습니다.");
        } else {
            System.out.println("주민등록번호 자릿수가 틀립니다.");
        }
    }
}
