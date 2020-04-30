package interface_8.default_method.inheritance;

public interface ParentInterface {
    public abstract void method1();
    public default void method2() {
        System.out.println("ParentInterface method2");
    }
}
