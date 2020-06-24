package stream_16.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Iterator(반복자)와 Stream으로 배열의 요소를 출력해서
 * 둘의 차이를 이해하자.
 */

public class IteratorVsStreamExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("홍길동", "신용권", "김자바");

        // Iterator를 이용해서 List에 있는 값을 출력
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }

        System.out.println();

        // Stream을 이용해서 List에 있는 값을 출력
        Stream<String> stringStream = list.stream();
        // forEach 메소드는 consumer라는 함수적 인터페이스를 가지고있다.
        stringStream.forEach(name -> System.out.println(name));

        // 만약 람다식 없이 생성하면 아래와 같은 것이다.
        stringStream.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        // 그리고 메소드 참조를 이용해석 구현하면 아래와 같다.
        stringStream.forEach(System.out::println);
    }
}
