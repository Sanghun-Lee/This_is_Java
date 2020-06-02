package lambda_expression_14.use_variable.class_member;

// this 의 사용

public class UsingThis {
    public int outterField = 10;

    // 중첩 클래스
    class Inner {
        int InnerField = 20;

        // 중첩 클래스의 메소드
        void method() {
            MyFunctionalInterface fi = () -> {
                // 람다식에서 외부 클래스의 필드를 접근하기 위해선 아래와 같이 접근한다.
                System.out.println("outterField : " + outterField);
                System.out.println("outterField : " + UsingThis.this.outterField);

                // 그냥 this 를 붙이면 내부 클래스의 필드에 접근하게 된다.
                System.out.println("innerField : " + InnerField);
                System.out.println("innerField : " + this.InnerField);
            };
            fi.method();
        }
    }
}
