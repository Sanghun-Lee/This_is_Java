package api_11.string.method;

// 문자열을 모두 소문자로 : toLowerCase()
// 문자열을 모두 대문자로 : toUpperCase()

public class StringToLowerUpperCaseExample {
    public static void main(String[] args) {
        String str1 = "Java Programming";
        String str2 = "JAVA Programming";

        System.out.println(str1.equals(str2));

        // 대소문자가 섞인 문자열이 같은지 확인하려면 모두 소문자 또는 대문자로 바꾼 후, 비교해야된다.
        String lowerStr1 = str1.toLowerCase();
        String lowerStr2 = str2.toLowerCase();
        System.out.println(lowerStr1.equals(lowerStr2));

        // equalsIgnoreCase : 대소문자를 무시하고 동일한지 확인한다. -> 위 과정을 무시할 수 있다.
        System.out.println(str1.equalsIgnoreCase(str2));
    }
}
