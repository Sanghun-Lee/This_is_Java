package thread_12.group;

// WorkThread 를 ThreadGroup 에 속하도록 해보자.

public class ThreadGroupExample {
    public static void main(String[] args) {
        // main 스레드가 해당 코드를 실행해서, main 그룹의 하위 그룹으로 myGroup 이 생성된다.
        ThreadGroup threadGroup = new ThreadGroup("myGroup");

        // 2개의 thread 를 생성해서 myGroup 에 속하도록 한다.
        WorkThread workThreadA = new WorkThread(threadGroup, "workThread-A");   // 해당 스레드가 속할 그룹, 해당 스레드의 이름
        WorkThread workThreadB = new WorkThread(threadGroup, "workThread-B");

        workThreadA.start();
        workThreadB.start();

        System.out.println("[ main 스레드 그룹의 list() 메소드 출력 내용 ]");
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();    // 메인 스레드의 그룹을 받는다. (main thread 가 실행하기 때문에)
        mainGroup.list();
        System.out.println();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }

        System.out.println("[ myGroup 스레드 그룹의 interrupt() 메소드 호출 ]");
        threadGroup.interrupt();    // 이렇게 호춣하면 myGroup에 속한 모든 thread 들에 대해서 InterruptException 이 발생한다.
    }
}

// 스레드 그룹의 처음 생성 순서

// 1. system thread group 이 먼저 생성된다.
// 2. main 스레드 그룹이 가 system 의 하위 스레드로 생성된다.
// 3. main thread group 에 main thread 가 추가된다.
// 4. main thread group 아래에 myGroup 의 thread group 이 추가된다.
// 5. myGroup thread group 아래에 workThread-A, workThread-B thread 가 추가된다.
