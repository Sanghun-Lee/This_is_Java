package stream_16.kind.get_stream_of_array;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// 배열에서 stream을 얻는 방법
// Arrays.stream(T[]) : Stream<T> 리턴
// Arrays.stream(int[] / long[] / double[]) : IntStream / LongStream / DoubleStream 리턴
// Stream.of(T[]) : Stream<T> 리턴
// IntStream.of(int[]) : IntStream
// LongStream.of(long[]) : LongStream
// DoubleStream.of(double[]) : DoubleStream

public class FromArrayExample {
    public static void main(String[] args) {
        String[] strArray = { "홍길동", "신용권", "김미나" };
        Stream<String> stringStream = Arrays.stream(strArray);  // String이 객체 타입이라서 Stream<String> 을 리턴한다.
        // a 자리에는 string 값들이 하나씩 들어간다.
        stringStream.forEach(a -> System.out.println(a + ", "));
        System.out.println();

        int[] intArray = { 1, 2, 3, 4, 5};
        IntStream intStream = Arrays.stream(intArray);  // int stream을 리턴한다.
        // IntStream이라서 forEach 또한, Int 타입의 Consumer 를 필요로 한다.
        intStream.forEach(a -> System.out.println(a + ", "));
        System.out.println();
    }
}
