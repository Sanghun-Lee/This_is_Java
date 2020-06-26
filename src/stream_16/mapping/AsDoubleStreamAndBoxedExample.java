package stream_16.mapping;

/**
 * asDoubleStream 메소드는 IntStream의 int or LongStream의 long 을 double 요소로 타입 변환 해서 DoubleStream을 생성한다.
 * asLongStream 메소드는 int 를 long 타입으로 변환해서 LongStream을 생성한다.
 * boxed() 메소드는 int >> Integer / long >> Long / double >> Double 요소로 박싱해서 stream을 생성한다.
 */


import java.util.Arrays;
import java.util.stream.IntStream;

public class AsDoubleStreamAndBoxedExample {
    public static void main(String[] args) {
        int[] intArray = { 1, 2, 3, 4, 5 };

        IntStream intStream = Arrays.stream(intArray);  // IntStream 생성
        intStream
                .asDoubleStream()       // DoubleStream 생성
                .forEach(d -> System.out.println(d));

        // intStream.asDoubleStream()을 이용해서 IntStream >> DoubleStream으로 변환해 준다.

        System.out.println();

        intStream = Arrays.stream(intArray);
        intStream
                .boxed()    // Stream<Integer> 생성
                .forEach(obj -> System.out.println(obj.intValue()));

        // intStream.boxed()를 이용해서 IntStream >> Stream<Integer>로 변환해 준다.

    }
}
