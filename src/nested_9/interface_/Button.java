package nested_9.interface_;

public class Button {
    interface OnClickListener {     // 중첩 interface 선언, 추상 메소드로 onClick 생성
        abstract void onClick();
    }

    OnClickListener listener;       // 중첩 인터페이스 타입 필드 생성

    // interface 의 다형성
    void setOnClickListener(OnClickListener listener) { // 매개변수의 다형성
        this.listener = listener;
    }

    // touch 메소드를 호출하면 중첩 interface 에서 선언한 추상메소드 onClick 이 실행된다.
    // 해당 onClick 함수는 Button.OnClickListener interface 를 구현한 구현객체에서 Override 할 것 이다.
    void touch() {
        listener.onClick();
    }
}
