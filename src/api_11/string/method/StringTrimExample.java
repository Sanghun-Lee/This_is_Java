package api_11.string.method;

// 문자열의 앞뒤 공백을 잘라준다.
// 문자열 자체가 바뀌는게 아니라, 앞뒤 공백이 잘린 새로운 문자열을 리턴한다.
// 문자열 중간에 공백은 제거되지 않는다.

public class StringTrimExample {
    public static void main(String[] args) {
        String tel1 = "     02";
        String tel2 = "123    ";
        String tel3 = "      1234      ";

        String tel = tel1.trim() + tel2.trim() + tel3.trim();
        System.out.println(tel);
    }
}
