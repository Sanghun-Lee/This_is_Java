package interface_8.default_method;

public class MyClassB implements MyInterface {
    @Override
    public void method1() {
        System.out.println("MyClassB - method1() 실행");
    }

    // default method를 Override 한다.
    @Override
    public void method2() {
        System.out.println("MyClassB - method2() 실행");
    }
}
