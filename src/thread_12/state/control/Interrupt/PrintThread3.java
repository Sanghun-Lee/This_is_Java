package thread_12.state.control.Interrupt;

// Thread를 일시정지 상태로 만들지 않고 스래드를 종료하는 방법이 있다.
// boolean status = Thread.interrupted();
// boolean status = objThread.isInterrupted();
// 인터럽트를 발생시키면 위 두 메소드는 true를 리턴한다.
// 그래서 while(true)를 실행하다가, 위 두 메소드가 true를 리턴하면 break로 thread를 빠져나올 수 있다.

public class PrintThread3 extends Thread {
    @Override
    public void run() {
        while(true) {
            System.out.println("실행 중");
            if(Thread.interrupted())
                break;
        }
        System.out.println("자원 정리");
        System.out.println("실행 종료");
    }
}
