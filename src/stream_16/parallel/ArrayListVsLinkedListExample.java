package stream_16.parallel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 스트림 소스가 ArrayList인 경우와 LinkedList일 경우 대용량 데이터의 병렬 처리 성능을 테스트한 것이다.
 */

public class ArrayListVsLinkedListExample {
    // 요소 처리
    public static void work(int value) {}

    // 병렬 처리
    public static long testParallel(List<Integer> list) {
        long start = System.nanoTime();
        list.parallelStream().forEach(a -> work(a));
        long end = System.nanoTime();
        long resultTime = end - start;

        return resultTime;
    }

    // 순차 처리
    public static long testSequential(List<Integer> list) {
        long start = System.nanoTime();
        list.stream().forEach(ArrayListVsLinkedListExample::work);
        long end = System.nanoTime();
        long resultTime = end - start;

        return resultTime;
    }

    public static void main(String[] args) {
        // 소스 컬렉션
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        for(int i = 0; i < 1000000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        // 워밍업 - 실행 준비 과정에서 오차를 없애기 위해
        long arrayListParallel = testParallel(arrayList);
        long linkedListParallel = testParallel(linkedList);

        // 병렬 스트림 처리 시간 구하기
        arrayListParallel = testParallel(arrayList);
        linkedListParallel = testParallel(linkedList);

        if(arrayListParallel < linkedListParallel) {
            System.out.println("성능 테스트 결과 ArrayList 처리가 더 빠름 // arrayList time : " + arrayListParallel + " linkedList time : " + linkedListParallel);
        } else {
            System.out.println("성능 테스트 결과 LinkedList 처리가 더 빠름 // arrayList time : " + arrayListParallel + " linkedList time : " + linkedListParallel);
        }
    }
}
