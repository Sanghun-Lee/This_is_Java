package thread_12.state.control.stop_flag;

public class PrintThread1 extends Thread {
    private boolean stop;   // stop flag를 넣어서 stop이 true가 되면 Thread를 종료시킨다.

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    @Override
    public void run() {
        while(!stop) {  // stop이 true가 되면 실행을 멈춘다.
            System.out.println("실행 중");
        }
        System.out.println("자원 정리");
        System.out.println("실행 종료");
    }
}
