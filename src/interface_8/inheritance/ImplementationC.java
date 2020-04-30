package interface_8.inheritance;

public class ImplementationC implements InterfaceC {

    @Override
    public void methodA() {
        System.out.println("methodA");
    }

    @Override
    public void methodB() {
        System.out.println("methodB");
    }
    // 구현객체는 A와 B에 있는 모든 추상메소드를 구현해야 된다.

    @Override
    public void methodC() {
        System.out.println("methodC");
    }

}
