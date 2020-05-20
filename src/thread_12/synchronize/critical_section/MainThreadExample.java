package thread_12.synchronize.critical_section;

public class MainThreadExample {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        User1 user1 = new User1();
        user1.setCalculator(calculator);    // 같은 객체를 넘겨준다.
        user1.start();

        User2 user2 = new User2();
        user2.setCalculator(calculator);    // user1과 같은 객체를 넘겨준다.
        user2.start();
    }
}

// 결과는 50이 나온다.
// user1에 100을 넣었지만,
// 2초 대기하는 동안
// user2가 50으로 값을 바꾸었기 때문에
// 같은 객체를 가리키는 calculator 의 값이 50으로 바뀌어서
// 둘 다 50의 값이 출력된다.