package nested_9.anonymous.implements_;

public class AnonymousExample {
    public static void main(String[] args) {
        Anonymous anonymous = new Anonymous();

        // 익명 객체 필드 사용
        anonymous.remoteControl.turnOn();

        // 익명 객체 로컬 변수 사용 // method1에 로컬 익명 객체 변수가 선언되어있다.
        anonymous.method1();

        // 익명 객체를 메소드의 매개변수로 사용
        anonymous.method2(new RemoteControl() {
            @Override
            public void turnOn() {
                System.out.println("SmartTV를 켭니다.");
            }

            @Override
            public void turnOff() {
                System.out.println("SmartTV를 끕니다.");
            }
        });
    }
}
