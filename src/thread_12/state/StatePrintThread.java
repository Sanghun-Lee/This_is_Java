package thread_12.state;

public class StatePrintThread extends Thread {
    private Thread targetThread;

    public StatePrintThread(Thread thread) {
        this.targetThread = thread;
    }

    @Override
    public void run() {
        while(true) {
            Thread.State state = targetThread.getState();   // target thread의 state를 얻는다.
            System.out.println("타겟 스레드 상태 : " + state);

            // 객체 생성 상태일 경우 실행 대기 상태로 만든다.
            if(state == State.NEW) {
                targetThread.start();
            }

            if(state == State.TERMINATED) {
                break;
            }

            try {
                Thread.sleep(500);
            } catch (Exception e) {}
        }
    }
}
