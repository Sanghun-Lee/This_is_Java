package collection_framework_15.list.linked_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// ArrayList와 LinkedList의 성능 비교

public class LinkedListExample {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new LinkedList<String>();

        long startTime, endTime;

        /* 0번 자리에 100,000 개의 값을 추가할 때 성능 비교 */
        startTime = System.nanoTime();
        for(int i = 0; i < 100000; i++) {
            list1.add(0, String.valueOf(i));    // ArrayList의 성능
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList의 100,000개의 값을 0번에 추가하는데 걸리는 시간 : " + (endTime - startTime) / 1000000 + "ms");

        startTime = System.nanoTime();
        for(int i = 0; i < 100000; i++) {
            list2.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList의 100,000개의 값을 0번에 추가하는데 걸리는 시간 : " + (endTime - startTime) / 1000000 + "ms");

        list1.clear();
        list2.clear();
        System.out.println();
        /* 가장 뒤에 100,000개의 값을 추가할 때 성능 비교 */
        startTime = System.nanoTime();
        for(int i = 0; i < 100000; i++) {
            list1.add(String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList의 100,000개의 값을 끝에 추가하는데 걸리는 시간 : " + (endTime - startTime) / 1000000 + "ms");

        startTime = System.nanoTime();
        for(int i = 0; i < 100000; i++) {
            list2.add(String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList의 100,000개의 값을 끝에 추가하는데 걸리는 시간 : " + (endTime - startTime) / 1000000 + "ms");

        System.out.println();
        /* 0번부터 100,000번 까지의 값을 순서대로 참조하는데 성능 비교 */
        startTime = System.nanoTime();
        for(int i = 0; i < 100000; i++) {
            String value = list1.get(i);
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList의 1 ~ 100,000개의 값을 순서대로 참조하는데 걸리는 시간 : " + (endTime - startTime) / 1000000 + "ms");

        startTime = System.nanoTime();
        for(int i = 0; i < 100000; i++) {
            String value = list2.get(i);
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList의 1 ~ 100,000개의 값을 순서대로 참조하는데 걸리는 시간 : " + (endTime - startTime) / 1000000 + "ms");

        System.out.println();
        /* 100,000번 부터 0번까지 값을 역순으로 (100,000 -> 0) 참조하는데 성능 비교 */
        startTime = System.nanoTime();
        for(int i = 0; i < 100000; i++) {
            String value = list1.get(99999 - i);
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList의 1 ~ 100,000개의 값을 역순으로 참조하는데 걸리는 시간 : " + (endTime - startTime) / 1000000 + "ms");

        startTime = System.nanoTime();
        for(int i = 0; i < 100000; i++) {
            String value = list2.get(99999 - i);
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList의 1 ~ 100,000개의 값을 역순으로 참조하는데 걸리는 시간 : " + (endTime - startTime) / 1000000 + "ms");
    }
}
