package stream_16.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

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
    }
}
