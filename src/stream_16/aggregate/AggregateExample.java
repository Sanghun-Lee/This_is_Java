package stream_16.aggregate;

import java.util.Arrays;

// 집계
// stream 에선, 요소 갯수(count), 첫 번째 요소(findFirst())
// 최대, 최소, 평균, 총합 과 같은 기본 집계를 제공한다.
// OptionalXXX 를 리턴하는데, 해당 객체에서 값을 얻기 위해서는 get(), getAsDouble(), getAsInt()와 같은 메소드를 사용해야 한다.

public class AggregateExample {
    public static void main(String[] args) {
        long count = Arrays.stream(new int[] { 1, 2, 3, 4, 5 })
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println("2의 배수 갯수 : " + count);

        long sum = Arrays.stream(new int[] { 1, 2, 3, 4, 5})
                .filter(n -> n % 2 == 0)
                .sum();
        System.out.println("2의 배수의 합 : " + sum);

        double average = Arrays.stream(new int[] { 1, 2, 3, 4, 5})
                .filter(n -> n % 2 == 0)
                .average()
                .getAsDouble();
        System.out.println("2의 배수의 평균 : " + average);

        int max = Arrays.stream(new int[] { 1, 2, 3, 4, 5})
                .filter(n -> n % 2 == 0)
                .max()
                .getAsInt();
        System.out.println("최댓값 : " + max);

        int min = Arrays.stream(new int[] { 1, 2, 3, 4, 5})
                .filter(n -> n % 2 == 0)
                .min()
                .getAsInt();
        System.out.println("최솟값 : " + min);

        int first = Arrays.stream(new int[] { 1, 2, 3, 4, 5})
                .filter(n -> n % 3 == 0)
                .findFirst()
                .getAsInt();
        System.out.println("첫번째 3의 배수 : " + first);
    }
}
