package lambda_expression_14.api.default_method.andThen_compose;

import java.util.function.Function;

/**
 * function A는 Member -> Address로 리턴되고
 * function B는 Address -> String으로 리턴되어서
 *
 * functionA.andThen(functionB) 이면 Member -> Address -> String 으로
 * 최종적으로 String이 리턴된다.
 *
 * 그래서 functionAB는 Member -> String이 되고,
 * functionAB = functionA.andThen(functionB)가 될 수 있다.
 */

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

        // 이를 익명 구현 객체를 이용하면 다음과 같다.
        functionA = new Function<Member, Address>() {
            @Override
            public Address apply(Member member) {
                return member.getAddress();
            }
        };

        functionB = new Function<Address, String>() {
            @Override
            public String apply(Address address) {
                return address.getCity();
            }
        };

        functionAB = functionB.compose(functionA);

        city = functionAB.apply(new Member("홍길동", "hong", new Address("한국", "서울")));
        System.out.println("거주 도시 : " + city);
    }
}
