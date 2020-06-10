package stream_16.mapping;

import java.util.Arrays;
import java.util.List;

// 매핑 중 flatMapXXX()
// flatMapXXX() : 요소를 대체하는 복수 개의 요소들로 구성된 새로운 스트림을 리턴한다.
// 기존에 A, B 스트림이 있으면 A는 A1, A2 / B는 B1, B2 요소를 가지는 새로운 스트림이 생성된다.

public class FlatMapExample {
    public static void main(String[] args) {
        List<String> inputList1 = Arrays.asList("java8 lambda", "stream mapping");
        inputList1.stream()
                .flatMap(data -> Arrays.stream(data.split(" ")))
                .forEach(word -> System.out.println(word));
        // "java8 lambda" >> java8, lambda 로 대체된다.
        // "stream mapping" >> stream, mapping 으로 대체된다.

        System.out.println();

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
    }
}
