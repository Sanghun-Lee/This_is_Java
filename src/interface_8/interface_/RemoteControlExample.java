package interface_8.interface_;

public class RemoteControlExample {
    public static void main(String[] args) {
        // 인터페이스 객체 생성
        RemoteControl rc = null;
        rc = new Television();  // interface 를 implements 한 Class만 대입할 수 있다.

        rc.turnOn();        // Television 의 turnOn 메소드 호출
        rc.setMute(true);   // Default method 호출
        rc.turnOff();       // Television 의 turnOff 메소드 호출

        rc = new Audio();       // Audio 또는 RemoteControl 을 implements 했기 때문에 대입할 수 있다.

        rc.turnOn();        // Audio 의 turnOn 메소드 호출
        rc.setMute(true);   // Audio 의 Override 된 method 호출
        rc.turnOff();       // Audio 의 turnOff 메소드 호출

        // 정적 메소드(static method) 호출
        // 그냥 interface 이름 쓰고 바로 호출하면 된다.
        RemoteControl.changeBattery();

        // 익명 구현 객체
        // 자바소스파일을 만들지 않고도 interface 의 구현 객체를 만들 수 있다.
        RemoteControl rrc = new RemoteControl() {
            // 필드와 메소드 또한 선언할 수 있지만, 익명객체 안에서만 사용할 수 있다.
            private String str = "Simple String";

            // 선언과 동시에 interface 안에 있는 모든 추상메소드들을 Override 해야한다.
            @Override
            public void turnOn() {  /* 실행문 */   }

            @Override
            public void turnOff() { /* 실행문 */   }

            @Override
            public void setVolume(int volume) { /* 실행문 */   }
        };
    }
}
