package api_11.string.method;

// 문자열 대치 함수 replace()
// 첫 번째 매개값인 문자열을 찾아 두 번째 매개값인 문자열로 변환한 후 새로운 객체를 리턴한다.
// String 은 상수라서 완전히 새로운 객체를 리턴한다.

public class StringReplaceExample {
    public static void main(String[] args) {
        String oldStr = "자바는 객체지향언어 입니다. 자바는 풍부한 API를 지원합니다.";
        String newStr = oldStr.replace("자바", "JAVA");
        System.out.println(oldStr);
        System.out.println(newStr);
    }
}
