package thread_12.thread;

/*** Thread class 로부터 직접 thread 생성 ***/

// Thread의 생성
// Thread의 생성자 : Thread thread = new Thread(Runnable target);   // Runnable : interface
// Thread를 생성하기 위해선 Runnable interface 를 구현한 구현객체를 매개변수로 넣어야 한다.
// Runnable interface 에는 run() 추상 메소드가 선언되어 있고, 해당 메소드를 재정의 해야한다.
//
// Thread의 실행
// Thread 객체가 생성되면 thread.start() 메소드로 thread 를 실행할 수 있다.
// thread 가 실행되면 구현객체에서 Override 한 run 메소드가 실행된다.

import javax.tools.Tool;
import java.awt.*;

public class BeepPrintExample2 {
    public static void main(String[] args) {
        Runnable beepTask = new BeepTask();     // Runnable 구현 객체 생성
        Thread thread = new Thread(beepTask);   // Thread 생성 Runnable interface 의 구현 객체를 대입해야 한다.
        thread.start(); // 스레드가 시작된다.

        for(int i = 0; i < 5; i++) {
            System.out.println("띵");
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Thread 는 익명객체와 람다식을 이용해서 구현할 수도 있다.
        // Runnable 익명객체의 사용
        Thread thread1 = new Thread(new Runnable() {
            // thread 실행내용을 run 메소드 안에다 적는다.
            @Override
            public void run() {
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for(int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // 람다식 이용
        Thread thread2 = new Thread(() -> {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            for(int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
