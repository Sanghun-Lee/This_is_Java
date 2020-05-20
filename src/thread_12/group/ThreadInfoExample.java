package thread_12.group;

// 현재 실행중인 스레드 그룹의 이름을 얻어보자.
// getAllStackTraces() : 프로세스 내에서 실행하는 모든 스레드에 대한 정보를 얻는다.
// 리턴타입 : Map<Thread, StackTraceElement[]>

// 현재 스레드가 속한 스레드 그룹의 이름을 얻는 방법
// ThreadGroup group = Thread.currentThread().getThreadGroup();
// String groupName = group.getName();

import thread_12.daemon.AutoSaveThread;

import java.util.Map;
import java.util.Set;

public class ThreadInfoExample {
    public static void main(String[] args) {
        AutoSaveThread autoSaveThread = new AutoSaveThread();
        autoSaveThread.setName("AutoSaveThread");
        autoSaveThread.setDaemon(true);
        autoSaveThread.start();

        Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
        Set<Thread> threads = map.keySet(); // 프로세서에서 실행되는 모든 thread 들을 가져오는 코드이다.

        for(Thread thread : threads) {
            System.out.println("Name : " + thread + ((thread.isDaemon()) ? "(데몬)" : "(주)"));
            System.out.println("\t" + "소속 그룹 : " + thread.getThreadGroup().getName());
            System.out.println();
        }
    }
}
