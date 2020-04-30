package interface_8.inheritance;

public class Example {
    public static void main(String[] args) {
        ImplementationC impC = new ImplementationC();

        InterfaceA ia = impC;
        ia.methodA();           // InterfaceA 변수로 만들면 InterfaceA 에 있는 메소드만 호출할 수 있다.
        // ia.methodB();
        // ia.methodC();        // 둘 다 불가능
        System.out.println();

        InterfaceB ib = impC;
        // ib.methodA();
        ib.methodB();
        // ib.methodC();
        System.out.println();

        InterfaceC ic = impC;

        ic.methodA();
        ic.methodB();
        ic.methodC();       // InterfaceC 로 생성한 객체는 methodA, methodB, methodC 모두 호출가능하다.
    }
}
