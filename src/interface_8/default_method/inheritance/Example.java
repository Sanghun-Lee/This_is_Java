package interface_8.default_method.inheritance;

/*** default method 의 상속 ***/
// 부모에게 default method 가 있을 때 이를 상속받은 interface 가 할 수 있는 일 3가지
// 1. default method 를 단순히 상속만 받는다          (ChildInterface1)
// 2. Override 해서 실행 내용을 변경한다.              (ChildInterface2)
// 3. default method 를 추상메소드로 재선언한다.       (ChildInterface3)

public class Example {
    public static void main(String[] args) {
        ChildInterface1 ci1 = new ChildInterface1() {
            @Override
            public void method3() {
                System.out.println("ChildInterface1 ci1 method3()");
            }

            @Override
            public void method1() {
                System.out.println("ChildInterface1 ci1 method1()");
            }
        };

        ci1.method1();
        ci1.method2();      // ParentInterface 의 method2() 호출
        ci1.method3();

        System.out.println();

        ChildInterface2 ci2 = new ChildInterface2() {
            @Override
            public void method3() {
                System.out.println("ChildInterface2 ci2 method3()");
            }

            @Override
            public void method1() {
                System.out.println("ChildInterface ci2 method1()");
            }
        };

        ci2.method1();
        ci2.method2();  // ChildInterface2 의 method2가 호출된다.
        ci2.method3();

        System.out.println();

        ChildInterface3 ci3 = new ChildInterface3() {
            @Override
            public void method2() { // 추상메소드로 재선언 했기 때문에 재정의 해주어야 한다.
                System.out.println("ChildInterface3 ci3 method2()");
            }

            @Override
            public void method3() {
                System.out.println("ChildInterface3 ci3 method3()");
            }

            @Override
            public void method1() {
                System.out.println("ChildInterface3 ci3 method1()");
            }
        };

        ci3.method1();
        ci3.method2();  // 위에서 구현한 method2()함수로 호출된다.
        ci3.method3();
    }
}
