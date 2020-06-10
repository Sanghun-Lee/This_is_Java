package stream_16.matching;

import java.util.Arrays;

// stream - match
// 최종처리 단계에서 요소들이 해당 조건에 만족하는지 여부를 boolean으로 return 해 주는 stream

// allMatch(조건) : 모두 "조건"에 만족하면 true / 아니면 false
// anyMatch(조건) : 하나라도 "조건"에 만족하면 true / 아니면 false
// noneMatch(조건) : 모든 요소들이 "조건"을 만족하지 않으면 true / 아니면 false

public class MatchExample {
    public static void main(String[] args) {
        int[] intArr = { 2, 4, 6 };

        boolean result = Arrays.stream(intArr)
                .allMatch(a -> a % 2 == 0);
        System.out.println("모두 2의 배수인가? " + result);

        result = Arrays.stream(intArr)
                .anyMatch(a -> a % 3 == 0);
        System.out.println("하나라도 3의 배수가 있는가? " + result);

        result = Arrays.stream(intArr)
                .noneMatch(a -> a % 3 == 0);
        System.out.println("3의 배수가 없는가? " + result);
    }
}
