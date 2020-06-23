package lambda_expression_14.method_reference.constructor;

import java.util.function.BiFunction;
import java.util.function.Function;

// Member 클래스에는 매개 변수가 0개, 1개, 2개인 총 3개의 생성자가 존재한다.
public class ConstructorReferencesExample {
    public static void main(String[] args) {
        // 해당 코드를
        Function<String, Member> function1 = (string) -> new Member(string);

        // 아래와 같이 작성할 수 있다.
        function1 = Member::new;   // 생성자 참조
        Member member1 = function1.apply("angel");      // 매개값이 1개인 생성자 참조

        // 해당 코드도
        BiFunction<String, String, Member> function2 = (str1, str2) -> new Member(str1, str2);

        // 아래와 같이 작성될 수 있다.
        function2 = Member::new;
        Member member2 = function2.apply("신천사", "angel");   // 매개값이 2개인 생성자 참조
    }
}
