package nested_9.anonymous.GUI;

public class Window {
    Button button1 = new Button();
    Button button2 = new Button();

    // Button 클래스가 가지고있는 OnClickListener interface 타입으로 변수를 선언하고
    // 해당 초기값으로 익명 구현객체를 대입한다. (Button 의 OnClickListener 인터페이스 타입의 구현객체)
    // 필드 초기값으로 대입
    Button.OnClickListener listener = new Button.OnClickListener() {
        @Override
        public void onClick() {
            System.out.println("전화를 겁니다.");
        }
    };
    // Button.OnClickListener : 인터페이스 이름

    public Window() {
        button1.setOnClickListener(listener);   // 메소드의 매개변수로 필드값을 대입힌다.

        // 매개값으로 익명구현객체를 바로 대입한다.
        button2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick() {
                System.out.println("메시지를 보냅니다.");
            }
        });
    }


}
