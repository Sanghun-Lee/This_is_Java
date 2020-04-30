package nested_9.interface_;

// Button 클래스가 가지고있는 중첩 interface OnClickListener 를 구현하기 위해 implements 받았다.
public class CallListener implements Button.OnClickListener {
    // interface 의 추상메소드 Override
    @Override
    public void onClick() {
        System.out.println("전화를 겁니다.");
    }
}
