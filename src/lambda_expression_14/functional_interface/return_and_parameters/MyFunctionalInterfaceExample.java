package lambda_expression_14.functional_interface.return_and_parameters;

public class MyFunctionalInterfaceExample {
    public static void main(String[] args) {
        MyFunctionalInterface fi;

        // 람다식을 이용해서 매개변수와 리턴값이 있는 구현객체 생성
        fi = (x, y) -> {
            int result = x + y;
            return result;
        };
        fi.method(2, 5);

        fi = (x, y) -> { return x + y;};
        fi.method(2, 5);

        // 명령어 한 줄 시 중괄호 생략, return 만 있을 시 return 생략
        fi = (x, y) -> x + y;
        fi.method(2, 5);

        // 다른 메소드를 호출해서 리턴해도 return 생략 가능
        fi = (x, y) -> sum(x, y);
        fi.method(2, 5);

    }
    public static int sum(int x, int y) {
        return x + y;
    }
}
