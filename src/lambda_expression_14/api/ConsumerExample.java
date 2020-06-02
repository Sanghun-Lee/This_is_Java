package lambda_expression_14.api;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

// Consumer 함수적 인터페이스
// 리턴값이 없는 accept 메소드를 가지고있다.
// 매개값을 소비하는 역할을 한다. (소비 : 사용만 할 뿐 리턴값이 없다.)

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> consumer = t -> System.out.println(t + "8");
        consumer.accept("java");

        // t와 u의 두 개의 매개값을 받아서 println 으로 소비를 하겠다 >> consumer
        BiConsumer<String, String> biConsumer = (t, u) -> System.out.println(t + u);
        biConsumer.accept("Java", "8");

        // 매개값을 double type 으로 받아서 println 으로 소비한다.
        DoubleConsumer doubleConsumer = d -> System.out.println("java" + d);
        doubleConsumer.accept(8.0);

        ObjIntConsumer<String> objIntConsumer = (t, i) -> System.out.println(t + i);
        objIntConsumer.accept("Java", 8);
    }
}
