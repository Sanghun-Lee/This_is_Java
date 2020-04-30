package inheritance_7.polymorphism;

// 자동 타입 변환
// 자식은 부모의 특징과 기능을 상속받기 때문에 "부모클래스 변수 = 자식클래스타입"이 가능하다.

class A {}

class B extends A {}
class C extends A {}

class D extends B {}
class E extends C {}

// A >> B, C / B >> D / C >> E --> A >> D && A >> E
public class PromotionExample {
    public static void main(String[] args) {
        B b = new B();
        C c = new C();
        D d = new D();
        E e = new E();  //  각자 클래스로 객체 생성

        A a1 = b;   // 부모클래스인 A 타입의 변수 a1에 A의 자식클래스타입 변수인 b의 대입이 가능하다.
        A a2 = c;   // 같은 이유이댜.
        A a3 = d;   // d도 결국에는 A의 자식이기때문에 대입 가능하다.
        A a4 = e;   // 같은 이유이다.

        B b1 = d;
        C c1 = e;   // A 에서와 같은 이유이다.

        // B b2 = e;    // 부모자식관계가 아니라서 에러가 일어난다.
        // C c2 = d;

        // 이렇게 "부모클래스 변수 = 자식 클래스 타입 변수"에 대입했을 경우
        // 해당 변수는 ""부모 클래스의 필드와 메서드만 접근 가능하다"".
        // ** 그런데, 자식클래스에서 *Override* 되었으면 *자식 클래스 메서드가 호출*된다.
    }
}
