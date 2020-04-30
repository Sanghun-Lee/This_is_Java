package nested_9.anonymous.GUI;

/*** UI 클래스 ***/
// 익명 구현 객체의 버튼 클릭 이벤트 처리

public class Button {
    // 중첩 interface
    interface OnClickListener {
        abstract void onClick();
    }

    OnClickListener listener;    // 인터페이스 타입의 필드

    // listener 의 setter        // 매개변수의 다형성
    // 외부에서 구현객체를 받아와서 필드의 listener 에 대입한다.
    void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }

    void touch() {
        listener.onClick(); // 구현객체가 Override 한 onClick 메소드 호출
    }
}
