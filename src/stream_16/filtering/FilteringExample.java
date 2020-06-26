package stream_16.filtering;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * 16.4 필터링 (distinct(), filter())
 * distinct : 중복 제거
 * filter(Predicate) : Predicate가 true인것만 참고
 */

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

        // 로컬변수를 사용해서 나타내면 아래와 같다.
        // 작동은 안한다. (distinct가 중간처리이고, 그 이후에 최종처리가 없어서 동작하지 않는것 같다.)
        Stream<String> nameStream = names.stream();
        Stream<String> remove_dup = nameStream.distinct();
        remove_dup.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
}
