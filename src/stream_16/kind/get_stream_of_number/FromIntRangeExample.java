package stream_16.kind.get_stream_of_number;

import java.util.stream.IntStream;

// 숫자 범위로부터 스트림 얻기

public class FromIntRangeExample {
    public static int sum;

    public static void main(String[] args) {
        // 1부터 100까지 범위에 해당하는 정수를 하나씩 가져와서 처리한다.
        IntStream stream = IntStream.rangeClosed(1, 100);
        // rangeClosed(a, b) : [a, b]
        // range(a, b) : [a, b)
        stream.forEach(a -> sum += a);
        System.out.println("총합 : " + sum);
    }
}
