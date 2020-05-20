package thread_12.synchronize.solve;

public class User2 extends Thread {
    private Calculator calculator;

    public void setCalculator(Calculator calculator) {
        this.setName("User2");
        this.calculator = calculator;
    }

    @Override
    public void run() {
        calculator.setMemory(50);      // 공유객체의 Calculator의 memory 값을 50으로 설정
    }
}
