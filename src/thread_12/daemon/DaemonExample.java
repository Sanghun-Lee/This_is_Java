package thread_12.daemon;

public class DaemonExample {
    public static void main(String[] args) {
        AutoSaveThread autoSaveThread = new AutoSaveThread();
        autoSaveThread.setDaemon(true); // main의 데몬 스레드로 만든다.
        autoSaveThread.start();         // 만드시 시작하기 전에 데몬으로 만들어야 한다.

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        System.out.println("메인 스레드 종료");
        // 메인 스레드가 종료되면 자동으로 데몬스레드인 autoSaveThread 의 스레드가 종료된다.
    }
}
