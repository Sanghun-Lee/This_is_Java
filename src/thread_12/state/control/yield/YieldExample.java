package thread_12.state.control.yield;

// 스레드 실행 양보 예제

public class YieldExample {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();

        threadA.start();
        threadB.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}

        threadA.work = false;   // Thread B만 실행

        try {
            Thread.sleep(3000);
        } catch(InterruptedException e) {}

        threadA.work = true;    // ThreadA, ThreadB 모두 실행

        try {
            Thread.sleep(3000);
        } catch(InterruptedException e) {}

        threadA.stop = true;
        threadB.stop = true;
    }
}
