package stream_16.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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
