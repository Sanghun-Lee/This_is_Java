package thread_12.state.control.join;

// Join : 다른 스레드가 종료될 때 까지 일시 정지 상태 유지

public class JoinExample {
    public static void main(String[] args) {
        SumThread sumThread = new SumThread();
        sumThread.start();

        try {
            sumThread.join();
        } catch (InterruptedException e) {}

        System.out.println("1 ~ 100까지 합 : " + sumThread.getSum());
    }
}
