package api_11.string.stringBuilder;

// StringBuilder
// 내부 버퍼에 문자열을 저장해두고 그 안에서 추가, 수정, 삭제 작업을 할 수 있도록 도와준다.
// StringBuilder sb = new StringBuilder();          // 기본적으로 16칸의 공간이 생성된다.
// StringBuilder sb = new StringBuilder(20);        // 20칸의 공간이 생성된다.
// StringBuilder sb = new StringBuilder("JAVA");    // 문자열 크기만큼 공간이 생성된다. (4)

public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();     // StringBuilder 객체 생성

        sb.append("Java ");
        sb.append("Program Study");            // 문자열 끝에 추가
        System.out.println(sb.toString());     // Java Program Study

        sb.insert(4, "2");          // 4번째 문자 뒤에 2 삽입
        System.out.println(sb.toString());     // Java2 Program Study

        sb.setCharAt(4, '6');        // 4번째 문자 뒤의 문자를 6으로 변경
        System.out.println(sb.toString());     // Java6 Program Study

        sb.replace(6, 13, "Book");  // 6번째 문자 뒤부터 13번째 문자까지를 "Book" 문자열로 대치
        System.out.println(sb.toString());      // Java6 Book Study

        sb.delete(4, 5);    // 5번째 문자를 삭제 (index 로는 4번째)
        System.out.println(sb.toString());      // Java Book Study

        int length = sb.length();       // 총 문자 수 얻기
        System.out.println("총 문자수 : " + length);

        String result = sb.toString();          // 버퍼에 있는 것을 String 타입으로 리턴
        System.out.println(result);
    }
}
