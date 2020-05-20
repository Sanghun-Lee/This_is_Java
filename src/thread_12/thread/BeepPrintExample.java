package thread_12.thread;

// Thread의 사용
// Main Thread 만 있다고 가정한다.
// 0.5초 주기로 beep 음을 울리고, 동시에 프린팅 작업을 한다.
// 해당 두 작업을 동시에 하기 위해선 두 작업중 하나는 메인 스레드가 아닌, 다른 스레드에서 일어나야 한다.

import java.awt.*;

public class BeepPrintExample {
    // java 코드가 실행되면 자동으로 main thread 가 하나 생성되고, 실행된다.
    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();      // toolkit 객체 얻기
        for(int i = 0; i < 5; i++) {
            toolkit.beep(); // beep 음 발생
            try {
                Thread.sleep(500);  // 0.5초간 일시정지
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for(int i = 0; i < 5; i++) {
            System.out.println("띵");
            try {
                Thread.sleep(500);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
