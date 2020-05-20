package thread_12.state.control.yield;

// Yield 메소드 : 다른 스레드에게 실행을 양보한다.

public class ThreadB extends Thread {
    public boolean stop = false;    // 종료 flag
    public boolean work = true;     // 작업 진행 여부 flag

    @Override
    public void run() {
        while(!stop) {
            if(work) {
                System.out.println("ThreadB 작업 내용");
            } else {
                Thread.yield(); // work가 false가 되면 다른 스레드에게 실행을 양보한다.
            }
        }
    }
}
