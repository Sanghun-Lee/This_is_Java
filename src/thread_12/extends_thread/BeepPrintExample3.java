package thread_12.extends_thread;

import java.awt.*;

/*** Thread 하위 클래스로부터 thread 생성 ***/

public class BeepPrintExample3 {
    public static void main(String[] args) {
        Thread thread = new BeepThread();   // 부모 class = new 자식 class 를 이용해서 객체 생성
        thread.start();                     // thread 시작

        for(int i = 0; i < 5; i++) {
            System.out.println("띵");
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 또한 아래와 같이 익명객체를 이용해서 thread 를 생성할 수 있다.
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for(int i = 0; i < 5; i++) {
                    toolkit.beep();
                    try {
                        Thread.sleep(500);
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }
}
