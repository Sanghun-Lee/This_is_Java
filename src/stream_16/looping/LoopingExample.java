package stream_16.looping;

import java.util.Arrays;

// looping : stream의 요소 전체를 반복하는 것을 말한다.
// peek()   : 중간 처리 메소드
// forEach() : 최종 처리 메소드

public class LoopingExample {
    public static void main(String[] args) {
        int[] intArr = { 1, 2, 3, 4, 5 };
        System.out.println("[peek()를 마지막에 호출한 경우]");
        Arrays.stream(intArr)
                .filter(a -> a % 2 == 0)
                .peek(System.out::println); // 동작하지 않는다.

        System.out.println("[최종 처리 메소드를 마지막에 호출한 경우]");
        int total = Arrays.stream(intArr)
                .filter(a -> a % 2 == 0)
                .peek(n -> System.out.println(n))   // 동작한다.
                .sum();     // 최종 메소드

        System.out.println("총합 : " + total);

        System.out.println("[forEach()를 마지막에 호출한 경우]");
        Arrays.stream(intArr)
                .filter(a -> a % 2 == 0)
                .forEach(System.out::println);  // 최종 메소드로 동작한다.
    }
}
