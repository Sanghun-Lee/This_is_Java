package interface_8.default_method;

// 기존에 구현해 놓은 interface
// 여기에 해당 interface를 수정해서 추상메소드를 하나 더 필요하게 되었다면
// 기존에 해당 interface를 필요로 했던 MyClassA 구현객체에 해당 interface의 모든 추상메소드를 재정의하지 않아서 문제가 생긴다.
// 그래서 더 구현할 메소드를 default method로 구현하게 되면 MyClassA에도 문제가 없고, 추가적인 메소드를 받는 MyClassB도 Override 하면 되기 때문에 문제가 없어진다.

public interface MyInterface {
    public abstract void method1();

    public default void method2() {
        System.out.println("MyInterface - method2() 실행");
    }
}
