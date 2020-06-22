package nested_9.anonymous.implements_;

public class Anonymous {
    // 기존에는 아래와 같은 방법을 이용했어야 했다.
    // RemoteControl remoteControl = new [RemoteControl 구현 클래스] ();

    // 필드의 초기값으로 interface 대입
    // 선언과 동시에 초기값으로 대입
    RemoteControl remoteControl = new RemoteControl() {
        @Override
        public void turnOn() {
            System.out.println("TV를 켭니다.");
        }

        @Override
        public void turnOff() {
            System.out.println("TV를 끕니다.");
        }
    };


    void method1() {
        // 로컬 변수값 으로 대입
        RemoteControl localVar = new RemoteControl() {
            @Override
            public void turnOn() {
                System.out.println("Audio를 켭니다.");
            }

            @Override
            public void turnOff() {
                System.out.println("Audio를 끕니다.");
            }
        };

        // 로컬 변수의 사용
        localVar.turnOn();
    }

    // 메소드의 매개변수로 인터페이스타입의 변수를 받는다.
    void method2(RemoteControl rc) {
        rc.turnOn();
    }
}
