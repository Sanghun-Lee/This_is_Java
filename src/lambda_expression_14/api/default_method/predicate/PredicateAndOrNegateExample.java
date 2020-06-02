package lambda_expression_14.api.default_method.predicate;

import java.util.function.IntPredicate;

public class PredicateAndOrNegateExample {
    public static void main(String[] args) {
        // 2의 배수 검사
        IntPredicate predicateA = a -> a % 2 == 0;

        // 3의 배수 검사
        IntPredicate predicateB = (a) -> a % 3 == 0;

        IntPredicate predicateAB;
        boolean result;

        // and()
        predicateAB = predicateA.and(predicateB);
        result = predicateAB.test(9);   // A가 true 이고, B도 true 이면 AB가 true 가 나온다.
        System.out.println("9는 2와 3의 배수입니까? " + result);

        // or()
        predicateAB = predicateA.or(predicateB);
        result = predicateAB.test(9);
        System.out.println("9는 2또는 3의 배수 입니까? : " + result);

        // negate()
        predicateAB = predicateA.negate();
        result = predicateAB.test(9);
        System.out.println("9는 홀수 입니까? : " + result);
    }
}
