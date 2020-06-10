package stream_16.filtering;

import java.util.Arrays;
import java.util.List;

public class FilteringExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("홍길동", "신용권", "김자바", "신용권", "신민철");

        names.stream()
                .distinct() // 중복 제거
                .forEach(n -> System.out.println(n));
        System.out.println();

        names.stream()
                .filter(n -> n.startsWith("신"))
                .forEach(System.out::println);
        System.out.println();

        names.stream()
                .distinct()
                .filter(n->n.startsWith("신"))
                .forEach(System.out::println);
    }
}
