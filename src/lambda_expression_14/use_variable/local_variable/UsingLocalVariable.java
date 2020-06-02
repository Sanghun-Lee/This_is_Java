package lambda_expression_14.use_variable.local_variable;

// Final 특정을 가지는 로컬 변수
// 람다식도 결국에는 구현 클래스라서 메소드 내부에서 선언 할 때, 메소드 매개변수 or 내부 변수를 사용하면 final 특성을 갖게 된다.

public class UsingLocalVariable {
    // UsingLocalVariable class 의 메소드
    void method(int arg) {  // 익명구현객체에서 해당 변수를 사용하기 때문에 final 특성을 갖게 된다.
        int localVar = 40;  // 익명구현객체에서 해당 변수를 사용하기 때문에 final 특성을 갖게 된다.

        // arg = 31;        // final 특성 때문에 수정 불가
        // localVar = 41;   // final 특성 때문에 수정 불가

        // 람다식
        MyFunctionalInterface fi = () -> {
            // 로컬변수를 읽는다.
            System.out.println("arg : " + arg);
            System.out.println("localVar : " + localVar);
        };
        fi.method();
    }
}
