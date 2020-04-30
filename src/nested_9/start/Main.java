package nested_9.start;

public class Main {
    public static void main(String[] args) {
        A a = new A();

        // 인스턴스 멤버 클래스 객체 생성
        A.B b = a.new B();      // A객체 생성 후 인스턴스 멤버 클래스를 생성할 수 있다.
        b.field1 = 3;
        b.method1();

        // 정적 멤버 클래스 객체 생성
        A.C c = new A.C();      // 왼쪽과 같은 방식으로 생성할 수 있다.
        c.field1 = 5;
        c.method1();
        A.C.field2 = 3;         // 정적 변수는 A를 거치고 C를 통해서 접근할 수 있다.
        A.C.method2();

        // 인스턴스 멤버 클래스는 바깥 클래스(A)의 객체 변수를 통해서 생성자를 호출할 수 있고 (a.new B())
        // 정적 멤버 클래스는 바깥 클래스(A)를 통해서 바로 생성자를 호출할 수 있다. (new A.C())

        // 로컬 클래스 객체 생성을 위한 메소드 호출
        a.method(); // method 내부에 선언되어있는 D 클래스가 호출된다.
    }
}
