package inheritance_7.instanceof_;

/*** instanceof - 객체 타입 확인 ***/

public class InstanceofExample {
    public static void method1(Parent parent) {
        if(parent instanceof Child) {   // Child 로 타입 변환이 가능한지 확인
            Child child = (Child) parent;
            System.out.println("method1 - Child 로 변환 성공");
        }
        else {
            System.out.println("method1 - Child 로 변환되지 않음");
        }
    }

    // instanceof 로 확인하지 않았기 때문에 ClassCastException 이 발생할 수 있다.
    public static void method2(Parent parent) {
        Child child = (Child) parent;
        System.out.println("method2 - Child 로 변환 성공");
    }

    public static void main(String[] args) {
        Parent parentA = new Child();

        method1(parentA);
        method2(parentA);   // Child 객체를 매개값으로 전달

        Parent parentB = new Parent();

        method1(parentB);
        method2(parentB);   // 예외발생
    }
}
