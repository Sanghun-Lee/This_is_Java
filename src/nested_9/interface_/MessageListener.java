package nested_9.interface_;

// CallListener 의 설명과 동일
public class MessageListener implements Button.OnClickListener {
    @Override
    public void onClick() {
        System.out.println("메시지를 보냅니다.");
    }
}
