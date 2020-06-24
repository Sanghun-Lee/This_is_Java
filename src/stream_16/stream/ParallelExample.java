package stream_16.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 스트림의 특징2
 * 내부 반복자를 사용하므로 병렬 처리가 쉽다.
 *
 * Iterator의 경우 next() 메소드로 collection 에서 다음 요소를 받고
 * 개발자의 코드에 의해서 출력한다.
 * while(없을 때 까지) {
 *     다음꺼 받아서
 *     "원하는 처리 실행"
 * }
 *
 * 하지만 stream의 경우 컬렉션 내부에서 요소들을 반복시키기 때문에
 * 개발자는 "원하는 처리 실행" 코드에만 집중할 수 있다.
 *
 * 또한, 벙렬 처리가 컬렉션 내부에서 처리되기 때문에 병렬적으로 요수를 처리할 수 있다.
 */

public class ParallelExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("홍길동", "신용권", "김자바", "람다식", "박병렬");

        // 순차처리 (Single Thread를 이용해서 처리한다.)
        Stream<String> stream = list.stream();
        // 메소드 참조 (s -> ParallelExample.print(s) 와 동일하다)
        stream.forEach(ParallelExample::print);

        System.out.println();

        // 병렬처리 (multi Thread를 이용해서 처리한다)
        Stream<String> parallelStream = list.parallelStream();
        parallelStream.forEach(ParallelExample::print);


    }
    public static void print(String str) {
        System.out.println(str + " : " + Thread.currentThread().getName());
    }
}
