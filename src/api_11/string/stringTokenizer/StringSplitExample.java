package api_11.string.stringTokenizer;

// split() 메소드의 사용
// 문자열을 분리해주는 메소드이고, 정규표현식을 이용해서 문자열을 분리한 후, String[] 의 타입으로 값을 return 해 준다.

public class StringSplitExample {
    public static void main(String[] args) {
        String text = "홍길동&이수홍,박연수,김자바-최명호";

        // split 뒤에 정규표현식을 사용해서 문자열을 분리할 수 있다. & , - 이 있으면 분리한다.
        String[] names = text.split("&|,|-");
        for(String name : names) {
            System.out.println(name);
        }
    }
}
