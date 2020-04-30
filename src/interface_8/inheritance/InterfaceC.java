package interface_8.inheritance;

// interface 도 상속이 존재하고, InterfaceC 를 구현할 구현객체는 A, B, C에 있는 모든 추상메소드를 재정의 해야된다.
// interface 는 다중상속 가능하다.
public interface InterfaceC extends InterfaceA, InterfaceB {
    public abstract void methodC();
}
