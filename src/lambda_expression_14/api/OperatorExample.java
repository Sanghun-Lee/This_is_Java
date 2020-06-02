package lambda_expression_14.api;

import java.util.function.IntBinaryOperator;

public class OperatorExample {
    private static int[] scores = { 92, 95, 87};

    public static int maxOrMin(IntBinaryOperator operator) {
        int result = scores[0];
        for(int score : scores) {
            result = operator.applyAsInt(result, score);
        }
        return result;
    }

    public static void main(String[] args) {
        // 최댓값 얻기
        // 큰 값을 리턴하는 람다식
        int max = maxOrMin((a, b) -> {
            return a >= b ? a : b;
        });

        System.out.println("최댓값 : " + max);

        // 최솟값 얻기
        // 작은 값을 리턴하는 람다식
        int min = maxOrMin((a, b) -> a >= b ? b : a);
        System.out.println("최솟값 : " + min);
    }
}
