package api_11.string.method;

// String method
// chatAt(int index);
// 특정 위치의 문자열을 리턴한다.
// 인덱스는 0 ~ 문자열 길이 - 1 까지의 값이 들어갈 수 있다.

public class StringCharAtExample {
    public static void main(String[] args) {
        String ssn = "010624-3230123";
        char sex = ssn.charAt(7);   // 7번째 문자를 받아서 성별을 확인한다.

        switch(sex) {
            case '1':
            case '3':
                System.out.println("남자 입니다.");
                break;

            case '2':
            case '4':
                System.out.println("여자 입니다.");
                break;
        }
    }
}
