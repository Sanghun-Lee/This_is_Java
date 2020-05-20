package thread_12.state.control.wait;

public class WaitNotifyExample {
    public static void main(String[] args) {
        WorkObject sharedObject = new WorkObject(); // ThreadA, ThreadB가 공유하는 공유객체를 생성한다.

        ThreadA threadA = new ThreadA(sharedObject);
        ThreadB threadB = new ThreadB(sharedObject);

        threadA.start();
        threadB.start();
    }
}

// ThreadA가 실행되면, methodA가 실행되고, 실행이 다 끝나고 난 후, notify() 메소드로 ThreadB를 실행한다.
// 그리고 ThreadA는 wait() 메소드로 일시 정지 상태가 된다.
// ThreadB가 실행되면, methodB의 내용이 다 실행되고 난 후, notify() 메소드로 wait() 상태인 ThreadA를 다시 실행 대기 상태로 만든다.
// 그 후, ThreadB는 다시 wait() 메소드로 일시 정지 상태가 된다.

// 이러한 과정으로 ThreadA >> ThreadB >> ThreadA >> ThreadB >> ThreadA .... A와 B가 순서대로 실행되도록 보장받을 수 있다.

