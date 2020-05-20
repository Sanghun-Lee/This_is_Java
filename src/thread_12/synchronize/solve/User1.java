package thread_12.synchronize.solve;

public class User1 extends Thread {
    private Calculator calculator;

    public void setCalculator(Calculator calculator) {
        this.setName("User1");
        this.calculator = calculator;
    }

    @Override
    public void run() {
        calculator.setMemory(100);      // 공유객체의 Calculator의 memory 값을 100으로 설정
    }
}
