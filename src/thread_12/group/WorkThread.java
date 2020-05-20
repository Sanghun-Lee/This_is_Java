package thread_12.group;

// Thread 그룹을 생성해 보자.
// WorkThread 는 생성시에 들어오는 threadGroup 에 속하게 된다.

public class WorkThread extends Thread {
    // thread 그룹 생성을 위해선 아래와 같이 생성자를 생성한다.
    public WorkThread(ThreadGroup threadGroup, String threadName) {
        super(threadGroup, threadName);
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(1000); // InterruptException 을 발생시키기 위해 sleep 을 호출한다.
            } catch (InterruptedException e) {
                // Interrupt exception 이 발생하면 while 문을 빠져나와 thread 를 종료시킨다.
                System.out.println(getName() + " interrupted");
                break;
            }
        }
        System.out.println(getName() + " 종료됨");
    }
}
