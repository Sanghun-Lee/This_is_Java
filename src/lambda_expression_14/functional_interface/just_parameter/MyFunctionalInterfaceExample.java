package lambda_expression_14.functional_interface.just_parameter;

// 매개 변수가 있는 람다식

public class MyFunctionalInterfaceExample {
    public static void main(String[] args) {
        MyFunctionalInterface fi;

        // 매개변수가 있는 람다식
        // method 람다식으로 재정의
        fi = (x) -> {
          int result = x * 5;
          System.out.println(result);
        };
        fi.method(2);

        fi = (x) -> { System.out.println(x * 5);};
        fi.method(5);

        // 매개변수가 한 개 라면 괄호를 생략할 수 있다.
        fi = x -> System.out.println(x * 5);
        fi.method(2);
    }
}
