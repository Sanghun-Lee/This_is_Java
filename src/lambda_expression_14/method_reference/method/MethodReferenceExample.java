package lambda_expression_14.method_reference.method;

import java.util.function.IntBinaryOperator;

public class MethodReferenceExample {
    public static void main(String[] args) {
        IntBinaryOperator operator;

        // 정적 메소드 참조
        operator = (x, y) -> Calculator.staticMethod(x, y);
        System.out.println("결과1 : " + operator.applyAsInt(3, 4));

        operator = Calculator::staticMethod;    // 위 정적 메소드 참조를 이와같이 작성할 수 있다.
        System.out.println("결과2 : " + operator.applyAsInt(3, 4));

        // 인스턴스 메소드 참조
        Calculator obj = new Calculator();
        operator = (x, y) -> obj.instanceMethod(x, y);
        System.out.println("결과3 : " + operator.applyAsInt(3, 4));

        operator = obj :: instanceMethod;       // 위 인스터스 메소드 참조를 이와 같이 작성할 수 있다.
        System.out.println("결과4 : " + operator.applyAsInt(3, 4));
    }
}
