package thread_12.state.control.Interrupt;

// 스래드를 종료하는 두 번째 방법
// 인터럽트를 발생시킨다.
// 인터럽트를 발생시키면 실행중인 thread는 InterruptException 이 발생하고 그래서 Thread를 종료시킨다.
// ** 그런데 문제는 thread가 실행 중 또는 실행 대기 중 상태에서는 인터럽트가 발생해도 종료되지 않는다.
// wait 메소드나 sleep 으로 일시 정지 상태가 되야지 스래드를 종료시킨다.

public class InterruptExample {
    public static void main(String[] args) {
        Thread thread = new PrintThread2();
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        thread.interrupt(); // 스래드를 종료시키기 위해 인터럽트를 발생시킨다.
    }
}
