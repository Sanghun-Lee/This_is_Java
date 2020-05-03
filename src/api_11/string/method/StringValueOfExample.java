package api_11.string.method;

// valueOf : 기본타입의 값을 문자열로 바꾸어준다.
// 숫자를 문자열로 바꿔준다.

public class StringValueOfExample {
    public static void main(String[] args) {
        String str1 = String.valueOf(10);
        String str2 = String.valueOf(10.5);
        String str3 = String.valueOf(true);

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }
}
