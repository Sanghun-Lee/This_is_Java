package lambda_expression_14.method_reference.constructor;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ConstructorReferencesExample {
    public static void main(String[] args) {
        Function<String, Member> function1 = Member::new;   // 생성자 참조
        Member member1 = function1.apply("angel");      // 매개값이 1개인 생성자 참조

        BiFunction<String, String, Member> function2 = Member::new;
        Member member2 = function2.apply("신천사", "angel");   // 매개값이 2개인 생성자 참조
    }
}
