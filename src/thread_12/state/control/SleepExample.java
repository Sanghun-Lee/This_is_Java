package thread_12.state.control;

import java.awt.*;

// Thread.sleep(long millis) : 매개변수 값의 milli second 만큼 대기한다.
// Thread.sleep(long millis, int nanos)

public class SleepExample {
    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for(int i = 0; i < 10; i++) {
            toolkit.beep();
            try {
                Thread.sleep(3000);
            } catch (Exception e) {}
        }
    }
}
