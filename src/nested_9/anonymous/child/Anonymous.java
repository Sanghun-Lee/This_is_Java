package nested_9.anonymous.child;

/**
 * 익명 객체
 * 부모 필드에 자식 객체를 초기값으로 대입 하는 경우 새로운 클래스를 생성해야 한다.
 * 하지만, 자식 클래스가 재사용되지 않고, 해당 필드와 변수의 초기값으로만 사용할 경우 라면 익명 자식 객체를 생성해서 초기값으로 대입하는 것이 좋은 방법이다.
 */

public class Anonymous {
    // Person person = new Child();
    // 위와 같이 Child가 Anonymous 클래스에서만 사용되는 경우 아래와 같이 익명 자식 객체를 이용하는것이 좋다.

    // 필드의 초기값으로 대입 // 익명 자식 객체
    Person person = new Person() {  // 부모클래스로 생성한다.
        // 자식 클래스만 가지고있는 메소드
        void work() {
            System.out.println("출근합니다.");
        }

        // 부모 클래스의 메소드를 Override
        @Override
        void wake() {
            System.out.println("6시에 일어납니다.");
            work();
        }
    };

    void method1() {
        // 로컬 변수에 익명객체 대입
        Person localVar = new Person() {
            void walk() {
                System.out.println("산책합니다.");
            }

            @Override
            void wake() {
                System.out.println("7시에 일어납니다.");
                walk();
            }
        };

        localVar.wake();    // 로컬변수의 사용
        // 로컬변수는 해당 메소드 내에서만 사용할 수 있다.
    }

    // 매개변수로 부모 클래스를 넣었다.
    void method2(Person person) {
        person.wake();
    }
}
