package nested_9.access_control;

/*** 중첩 클래스의 접근 제한 ***/
// 바깥 클래스(A)에서 멤버 클래스(B, C)의 인스턴스(객체)를 생성할 때 어느정도 제약이 따른다.
// 인스턴스 멤버 클래스(B)의 경우 static class 가 아니기 때문에, static field, static method 내부에 B 객체를 생성하는 것은 에러를 일으킨다.
// static 멤버 클래스(C)의 경우 static class 이기 때문에, 아무런 제약을 받지 않는다.

// 멤버 클래스(B, C)에서 바깥 클래스(A)의 필드와 메소드를 접근할 때에도 제약이 따른다.
// 인스턴스 멤버 클래스(B)의 경우 모두 접근 가능하다.
// static 멤버 클래스(C)의 경우 static 변수, static method 만 접근 가능하다.

// 너무 당연한 소리다.
// B는 A가 생성되어야지만 생성할 수 있기 때문에, A 생성 전에 사용할 수 있는 static 변수와 메소드를 못쓴는 것은 당연하다.
// 그리고 C는 정적 멤버 클래스이기 때문에 A가 생성하고 접근 가능한 것들 (필드, 메소드)을 접근 못하는 것은 너무 당연하다.

// 바깥 클래스
public class A {
    // A constructor
    public A() { System.out.println("A 객체가 생성되었다."); }

    // 바깥 클래스의 인스턴스 필드, 메소드
    int field1;
    void methodA1() {}

    // 바같 클래스의 정적 필드 메소드,
    static int field2;
    static void methodA2 () {}

    // 1.1 인스턴스 멤버 클래스
    class B {   // 중첩 클래스
        // 생성자
        B() {   System.out.println("B 객체가 생성되었다."); }

        void method() {
            field1 = 10;
            methodA1();

            field2 = 20;
            methodA2();
        }
    }

    // 1.2 정적 멤버 클래스
    static class C {
        // 생성자
        C() {   System.out.println("C 객체가 생성되었다."); }

        void method() {
            // field1 = 20;     // 바깥 클래스의 인스턴스 필드는 접근할 수 없다.
            // methodA1();      // 바깥 클래스의 인스턴스 메소드도 접근할 수 없다.

            field2 = 40;        // 바깥 클래스의 정적 필드만 접근할 수 있다.
            methodA2();         // 바깥 클래스의 정적 메소드만 접근할 수 있다.
        }
    }

    /**** 바깥 클래스에서의 중첩 클래스 변수 접근 ****/
    // 바깥 클래스 A의 인스턴스 field
    B fieldB = new B();         // (o)
    C fieldC = new C();         // (o)

    // 바깥 클래스 A의 인스턴스 method
    void method1() {
        B var1 = new B();       // (o)
        C var2 = new C();       // (o)
    }

    // 바깥 클래스 A의 정적 필드 초기화
    // static B field3 = new B();  // (x) - B는 A 객체가 생성되어야지 B를 생성할 수 있는데 정적타입의 경우 A 객체를 생성하지 않아도 접근 가능하기때문에, 인스턴스 멤버 클래스의 경우 에러를 일으킨다.
    static C field4 = new C();  // (o)

    // 바깥 클래스 A의 정적 메소드
    static void method2() {
        // B var3 = new B();    // (x) - 정적 필드와 같은 내용이다. method2는 A객체 생성 없이도 접근할 수 있기 때문에 B를 호출하면 에러를 일으킨다.
        C var4 = new C();       // (o)
    }
}
