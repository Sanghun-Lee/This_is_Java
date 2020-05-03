package api_11.string.method;

// 문자열 잘라내기 substring()
// 주어진 인덱스에서 문자열을 추출한다.
// substring(int beginIndex, int endIndex)  : beginIndex(포함) 에서 endIndex(포함안됨) 까지 잘라서 새로운 객체를 생성한다.
// substring(int beginIndex) : beginIndex(포함)에서 끝까지 문자열을 추출한다.

public class StringSubstringExample {
    public static void main(String[] args) {
        // index 0 : "9", 1 : "8", 2 : "7", 3 : "5"....
        String ssn = "987564-1234567";

        String firstNum = ssn.substring(0, 6);
        System.out.println(firstNum);

        String secondNum = ssn.substring(7);
        System.out.println(secondNum);
    }
}
