package interface_8.default_method.inheritance;

// ChildInterface2 에서 Parent에게 받은 default method 를 재정의한다.
public interface ChildInterface2 extends ParentInterface {
    @Override
    default void method2() {
        System.out.println("ChildInterface2 method2");
    }

    public abstract void method3();
}
