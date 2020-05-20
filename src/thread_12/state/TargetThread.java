package thread_12.state;

public class TargetThread extends Thread {
    @Override
    public void run() {
        // 10억번 loop
        for(long i = 0; i < 1000000000; i++) {}

        // 1.5초간 대기
        try {
            Thread.sleep(1500);
        } catch (Exception e) {}

        // 다시 10억번 loop
        for(long i = 0; i < 1000000000; i++) {}
    }
}
