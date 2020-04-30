package interface_8.default_method;

public class DefaultMethodExample {
    public static void main(String[] args) {
        MyInterface my1 = new MyClassA();
        my1.method1();
        my1.method2();  // MyInterface 의 default method 가 실행된다.

        my1 = new MyClassB();

        my1.method1();
        my1.method2();  // MyClassB 의 default method 가 실행된다.
    }
}
