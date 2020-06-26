package stream_16.mapping;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 매핑 중 flatMapXXX()
 * flatMapXXX() : 요소를 대체하는 복수 개의 요소들로 구성된 새로운 스트림을 리턴한다.
 * 기존에 A, B 스트림이 있으면 A는 A1, A2 / B는 B1, B2 요소를 가지는 새로운 스트림이 생성된다.
 */


public class FlatMapExample {
    public static void main(String[] args) {
        List<String> inputList1 = Arrays.asList("java8 lambda", "stream mapping");

        Stream<String> listStream = inputList1.stream();

        inputList1.stream()
                .flatMap(data -> Arrays.stream(data.split(" ")))
                .forEach(word -> System.out.println(word));
        // "java8 lambda" >> java8, lambda 로 대체된다.
        // "stream mapping" >> stream, mapping 으로 대체된다.

        System.out.println();

        // 스트림을 람다식이 아닌, 익명 구현 객체를 이용해서 구현해 보자.
        inputList1.stream()
                .flatMap(new Function<String, Stream<String>>() {
                    @Override
                    public Stream<String> apply(String str) {
                        return Arrays.stream(str.split(" "));
                    }
                })
                .forEach(new Consumer<String>() {
                    @Override
                    public void accept(String str) {
                        System.out.println(str);
                    }
                });

        // inputList1.stream() 으로 Stream<String>을 얻는다.
        // flatMap으로 String을 받아서 String<String>으로 변환한다.
        // forEach가 String을 받아서 출력한다.


        List<String> inputList2 = Arrays.asList("10, 20, 30", "40, 50, 60");
        inputList2.stream()
                .flatMapToInt(data -> {
                    String[] strArr = data.split(",");
                    int[] intArr = new int[strArr.length];
                    for(int i = 0; i < strArr.length; i++) {
                        intArr[i] = Integer.parseInt(strArr[i].trim());
                    }
                    return Arrays.stream(intArr);
                })
                .forEach(System.out::println);

        // 위 스트림도 익명 구현 객체를 이용하면 다음과 같다.
        inputList2.stream()
                .flatMapToInt(new Function<String, IntStream> () {
                    @Override
                    public IntStream apply(String str) {
                        String[] strArr = str.split(",");          // 문자열을 ","기준으로 자르기
                        int[] intArr = new int[strArr.length];          // int배열 생성
                        for(int i = 0; i < strArr.length; i++) {
                            // 앞뒤 공백을 지우고 String값을 int값으로 변경
                            intArr[i] = Integer.parseInt(strArr[i].trim());
                        }
                        return Arrays.stream(intArr);   // int >> IntStream으로 변경
                    }
                })
                .forEach(new IntConsumer() {    // IntConsumer : int값을 받아서 소비
                    @Override
                    public void accept(int value) {
                        System.out.println(value);
                    }
                });
    }
}
