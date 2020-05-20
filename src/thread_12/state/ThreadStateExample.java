package thread_12.state;

// target thread 의 state는
// NEW >> RUNNABLE >> TIMED_WAITING (sleep) >> RUNNABLE >> TERMINATED 가 된다.

public class ThreadStateExample {
    public static void main(String[] args) {
        StatePrintThread statePrintThread = new StatePrintThread(new TargetThread());
        statePrintThread.start();
    }
}
