package api_11.string.method;

// String equals 메소드
// Object 에 정의된 equals 는 참조하는 객체의 동일성을 확인하지만
// String 이 Override 해서 객체 안에 있는 내용이 같은지 다른지 확인한다.

public class StringEqualsExample {
    public static void main(String[] args) {
        String var1 = new String("신민철");
        String var2 = "신민철";

        if(var1 == var2) {
            System.out.println("같은 String 객체를 참조");
        } else {
            System.out.println("다른 String 객체를 참조");
        }

        if(var1.equals(var2)) {
            System.out.println("같은 문자열을 가진다.");
        } else {
            System.out.println("다른 문자열을 가진다.");
        }
    }
}
