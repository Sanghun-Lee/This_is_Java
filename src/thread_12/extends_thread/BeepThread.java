package thread_12.extends_thread;

// Thread 를 돌릴 클래스에서 Thread class 를 상속받은 후, run 메소드를 override 해서
// thread 생성시에 override 한 run 메소드를 실행시킨다.

import java.awt.Toolkit;

public class BeepThread extends Thread{
    // thread 실행 내용 재정의
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
