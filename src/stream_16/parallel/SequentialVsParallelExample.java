package stream_16.parallel;

import java.util.Arrays;
import java.util.List;

public class SequentialVsParallelExample {
    public static void work(int value) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {}
    }

    // 순차 처리
    public static long testSequential(List<Integer> list) {
        long start = System.nanoTime();
        list.stream().forEach(a -> work(a));
        long end = System.nanoTime();
        long runTime = end - start;
        return runTime;
    }

    // 병렬 처리
    public static long testParallel(List<Integer> list) {
        long start = System.nanoTime();
        list.parallelStream().forEach(a -> work(a));
        long end = System.nanoTime();
        long runTime = end - start;
        return runTime;
    }

    public static void main(String[] args) {
        // 소스 컬렉션
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        // 순차 스트림 처리 시간 구하기
        long timeSequential = testSequential(list);

        // 병렬 처리 스트림 처리 시간 구하기
        long timeParallel = testParallel(list);

        if(timeParallel > timeSequential) {
            System.out.println("성능 테스트 결과 : 순차 처리가 더 빠름");
        } else {
            System.out.println("성능 테스트 결과 : 병렬 처리가 더 빠름");
        }
    }
}
