package nested_9.anonymous.child;

public class AnonymousExample {
    public static void main(String[] args) {
        Anonymous anonymous = new Anonymous();

        // 익명 객체 필드 사용 // Anonymous 클래스가 가지고 있는 클래스 필드(Person)의 사용 방법
        anonymous.person.wake();
        // 익명 객체 로컬 변수 사용   // method1을 호출하면 method1에 선언한 로컬 클래스가 사용된다.
        anonymous.method1();

        // Anonymous 클래스의 메소드인 method2의 매개값으로 익명 클래스를 넣었다.
        //
        anonymous.method2(new Person() {
            void study() {
                System.out.println("공부합니다.");
            }

            @Override
            void wake() {
                System.out.println("9시에 일어납니다.");
                study();
            }
        });
    }
}
