package stream_16.aggregate;

/**
 * 만약에 stream에 요소가 없을 때 평균값을 구하면 어떻게 될까
 *
 * List<Integer> list = new ArrayList<>();
 * double avg = list.stream().mapToInt(Integer::intValue).average().getAsDouble();
 * 위와 같은 경우 avg 값은 없게 된다. 그래서 print 하게 되면 NoSuchElementException 예외가 발생한다.
 *
 * 그래서 해결할 수 있는 방법이 3가지가 있다.
 * 1. isPresent()
 * 2. orElse()
 * 3. ifPresent()
 */


import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.DoubleConsumer;
import java.util.function.ToIntFunction;

public class OptionalExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        // 예외 발생 (java.util.NoSuchElementException)
        // double average = list.stream().mapToInt(Integer::intValue).average().getAsDouble();

        // 방법 1
        OptionalDouble optionalDouble = list.stream()
                .mapToInt(Integer::intValue)
                .average();

        // isPresent 메소드로 값이 있을 때만 평균값 출력
        if( optionalDouble.isPresent() ) {
            System.out.println("방법1 - 평균 : " + optionalDouble.getAsDouble());
        } else {
            System.out.println("방법1 - 평균 : 0.0");
        }

        // 방법 2
        // orElse 메소드로 값이 없으면 디폴트 값 설정
        double average = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println("방법2 - 평균 : " + average);

        // 방법 3
        // ifPresent로 값이 있을때만 괄호안의 람다식 사용
        list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .ifPresent(a -> System.out.println("방법3 - 평균 : " + a));

        // 익명 구현 객체를 이용하면 아래와 같다.
        list.stream()
                .mapToInt(new ToIntFunction<Integer>() {
                    @Override
                    public int applyAsInt(Integer value) {
                        return value.intValue();
                    }
                })
                .average()
                .ifPresent(new DoubleConsumer() {
                    @Override
                    public void accept(double value) {
                        System.out.println("방법3 - 평균 : " + value);
                    }
                });
    }
}
