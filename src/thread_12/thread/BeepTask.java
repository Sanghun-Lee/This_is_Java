package thread_12.thread;

import java.awt.*;

// Thread 는 Runnable interface 를 구현한 구현클래스를 필요로 한다.
// Runnable 에는 run() 추상메소드가 있고, 이를 Override 해야한다.
// Thread 가 실행되면 해당 run 메소드가 실행된다.

public class BeepTask implements Runnable {
    @Override
    public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for(int i = 0; i < 5; i++) {
            toolkit.beep();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
