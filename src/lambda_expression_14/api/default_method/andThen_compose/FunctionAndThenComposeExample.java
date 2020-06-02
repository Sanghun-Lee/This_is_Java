package lambda_expression_14.api.default_method.andThen_compose;

import java.util.function.Function;

public class FunctionAndThenComposeExample {
    public static void main(String[] args) {
        Function<Member, Address> functionA;
        Function<Address, String> functionB;
        Function<Member, String> functionAB;

        String city;

        functionA = (m) -> m.getAddress();
        functionB = m -> m.getCity();
        functionAB = functionB.compose(functionA);  // A 먼저 실행하고, B를 실행한 후, 결과를 AB에 저장한다.

        city = functionAB.apply(new Member("홍길동", "hong", new Address("한국", "서울")));
        System.out.println("거주 도시 : " + city);

        functionAB = functionA.andThen(functionB);

        city = functionAB.apply(new Member("홍길동", "hong", new Address("한국", "서울")));
        System.out.println("거주 도시 : " + city);
    }
}
