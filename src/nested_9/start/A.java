package nested_9.start;

/*** 중첩 클래스 ***/

/**
 * 클래스 내부에 또 클래스를 선언한 형태를 말한다.
 * 중첩 클래스 종류
 * 1. 멤버 클래스 : class 내부에 선언한 새로운 클래스 (B, C)
 *  1.1 인스턴스 멤버 클래스 : static 키워드 없이 선언한 클래스 (B), 바깥 클래스(A)의 객체를 생성해야지만 사용할 수 있다.
 *  1.2 정적 멤버 클래스 : static 키워드로 선언한 클래스 (C), 바깥 클래스(A)로 바로 접근할 수 있다. (바깥 클래스 객체를 생성할 필요가 없다.)
 * 2. 로컬 클래스 : class 의 method 내부에 선언한의 클래스 (D), method 가 실행중 일때만 사용할 수 있고, 해당 method 외부에서 접근할 수 없다.
 * 로컬 클래스도 로컬 변수라 생각하면 좀 쉽다.
 */


// 바깥 클래스
public class A {
    // A constructor
    public A() {
        System.out.println("A 객체가 생성되었다.");

        // A에서 B를 접근하는 방법은 그냥 class처럼 접근하면 된다.
        B b = new B();
        b.field1 = 3;
        b.method1();
    }

    // 1.1 인스턴스 멤버 클래스
    class B {   // 중첩 클래스
        // 생성자
        B() {
            System.out.println("B 객체가 생성되었다.");
        }

        // 필드
        int field1;
        // static int field2;       // static 필드는 생성할 수 없다.
        void method1() {}
        // static void method2() {} // static method 는 생성할 수 없다.
    }

    // 1.2 정적 멤버 클래스
    static class C {
        // 생성자
        C() {
            System.out.println("C 객체가 생성되었다.");
        }

        // field
        int field1;
        static int field2;          // static field 도 생성할 수 있다.
        void method1() {}
        static void method2() {}    // static method 도 생성할 수 있다.
    }

    void method() {
        // 2. 로컬 클래스
        class D {
            // 생성자
            D() { System.out.println("D 객체가 생성되었다.");}

            // 필드
            int field1;
            // static int field2;       // static field 는 생성할 수 없다.
            void method1() {}
            // static void method2() {}    // static method 도 생성할 수 없다.
        }
        // D 선언 끝

        // D 사용 / 로컬 클래스를 선언한 method 내부에서만 D를 생성하고 사용할 수 있다.
        D d = new D();
        d.field1 = 3;
        d.method1();
    }
}
