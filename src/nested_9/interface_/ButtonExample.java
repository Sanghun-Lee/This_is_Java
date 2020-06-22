package nested_9.interface_;

public class ButtonExample {
    public static void main(String[] args) {
        Button btn = new Button();      // Button 클래스 객체 생성

        // OnClickListener interface 의 setter
        // Button.OnClickListener 의 구현클래스인 CallListener 클래스를 생성해서 넘겨준다 >> 다형성
        btn.setOnClickListener(new CallListener());
        btn.touch();    // touch 메소드는 Override 한 onClick 메소드가 실행된다.

        btn.setOnClickListener(new MessageListener());
        btn.touch();

        // 이전에 인터페이스에서 확인했던 익명 구현객체로 인터페이스를 구현할 수 있다.
        btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick() {
                System.out.println("버튼을 누릅니다.");
            }
        });
        btn.touch();

        // 그리고 Button의 OnClickListener인터페이스가 함수적 인터페이스 이기 때문에 람다식으로 구현할 수 있다.
        btn.setOnClickListener(() -> System.out.println("람다식으로 버튼을 누릅니다."));
        btn.touch();
    }
}
