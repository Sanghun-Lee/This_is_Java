package api_11.format;

// 문자열을 작성할 때 "id : " + id 이런식으로 말고 더 좋은 방법이 있다.

import java.text.MessageFormat;

public class MessageFormatExample {
    public static void main(String[] args) {
        String id = "java";
        String name = "이상훈";
        String tel = "010-1234-1111";

        String text = "회원 ID : {0} \n회원 이름 : {1} \n회원 전화 : {2}";
        String result = MessageFormat.format(text, id, name, tel);
        System.out.println(result);
        System.out.println();

        String sql = "insert into number values( {0}, {1}, {2} )";
        Object[] arguments = { "'java'", "'이상훈'", "'010-1234-1111'"};
        String result2 = MessageFormat.format(sql, arguments);
        System.out.println(result2);
    }
}
