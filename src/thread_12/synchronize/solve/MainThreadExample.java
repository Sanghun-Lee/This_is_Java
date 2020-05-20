package thread_12.synchronize.solve;

public class MainThreadExample {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        User1 user1 = new User1();
        user1.setCalculator(calculator);    // 같은 객체를 넘겨준다.
        user1.start();  // user1의 run 메소드를 실행한다.

        User2 user2 = new User2();
        user2.setCalculator(calculator);    // user1과 같은 객체를 넘겨준다.
        user2.start();  // user2의 run 메소드를 실행한다.
    }
}

// Calculator 의 setMemory 메소드가 synchronized 키워드가 있어서
// user1이 setMemory 메소드를 사용할 때 lock이 걸리고,
// user2가 setMemory 메소드를 사용할 때 lock이 걸려있기 때문에 대기해야 한다.