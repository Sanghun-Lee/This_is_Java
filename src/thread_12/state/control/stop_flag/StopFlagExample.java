package thread_12.state.control.stop_flag;

// 기존에 있던 stop 메소드는 사용하지 않는것을 권장하고 있어서 (stop 메소드는 자원정리 없이 바로 종료시키기 때문이다.)
// run 메소드에 stop falg를 붙여서 stop 의 값이 1이면 자원 정리 후, Thread를 종료시키자.

public class StopFlagExample {
    public static void main(String[] args) {
        PrintThread1 printThread1 = new PrintThread1();

        printThread1.start();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // printThread 를 1초 후에 stop값을 true로 만들어 주어서 thread를 종료시킨다.
        printThread1.setStop(true);
    }
}
