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
    }
}
