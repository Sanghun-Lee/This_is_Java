package lambda_expression_14.api.default_method.andThen_compose;

import java.util.function.Consumer;

// andThen : A.andThen(B) : A 실행 후, B를 실행하는 것을 하나로 만든다.
// consumerAB = consumerA.andThen(consumerB) : consumerA 실행 후, consumerB 실행 하는것을 하나로 만들어서 consumerAB에 정의한다.
// consumerAB.accept(...) 를 호출하면 consumerA가 실행되고, consumerB가 실행된다.

public class ConsumerAndThenExample {
    public static void main(String[] args) {
        Consumer<Member> consumerA = (m) -> {
            System.out.println("consumerA : " + m.getName());
        };

        Consumer<Member> consumerB = (m) -> {
            System.out.println("consumerB : " + m.getId());
        };

        Consumer<Member> consumerAB = consumerA.andThen(consumerB);
        consumerAB.accept(new Member("홍길동", "hong", null));
    }
}
