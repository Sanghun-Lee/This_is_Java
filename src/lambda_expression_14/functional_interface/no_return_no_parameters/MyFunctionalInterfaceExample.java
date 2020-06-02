package lambda_expression_14.functional_interface.no_return_no_parameters;

// 매개변수와 리턴값이 없는 람다식

public class MyFunctionalInterfaceExample {
    public static void main(String[] args) {
        MyFunctionalInterface fi;

        // 람다식을 이용해서 MyFunctionalInterface 의 익명 구현 객체를 생성한다.
        fi = () -> {
            String str = "method call";
            System.out.println(str);
        };
        fi.method();

        fi = () -> { System.out.println("method call2");};
        fi.method();

        // 실행문이 한 줄 일 경우 중괄호 생략
        fi = () -> System.out.println("method call3");
        fi.method();
    }
}
