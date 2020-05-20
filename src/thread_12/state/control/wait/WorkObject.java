package thread_12.state.control.wait;

// 두 Thread의 작업 내용을 동기화 메소드로 작성한 공유 객체

public class WorkObject {
    public synchronized void methodA() {
        // ThreadA가 methodA의 작업을 수행한다.
        System.out.println("ThreadA의 methodA() 작업 실행");
        notify();
        try {
            wait();
        } catch(InterruptedException e) {}
    }

    public synchronized void methodB() {
        // ThreadB가 methodB의 작업을 수행한다.
        System.out.println("ThreadB의 methodB() 작업 실행 완료");
        notify();
        try {
            wait();
        } catch (InterruptedException e) {}
    }
}
