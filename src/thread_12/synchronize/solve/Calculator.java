package thread_12.synchronize.solve;

public class Calculator {
    private int memory;

    public int getMemory() {
        return memory;
    }

    // synchronized 키워드를 입력해서 해당 메소드는 하나의 thread만 실행하도록 만들 수 있다.
    public synchronized void setMemory(int memory) {
        this.memory = memory;           // 메모리에 값 저장 후
        try {
            Thread.sleep(2000);     // 2초간 기다린다.
        } catch (Exception e) {
        }

        System.out.println(Thread.currentThread().getName() + " : " + this.memory);
    }
    public void method1(int memory) {
        // 이런식으로 동기화 block을 만들 수 있다.
        synchronized (this) {
            this.memory = memory;
            try {
                Thread.sleep(2000);
            } catch (Exception e) {}
        }
    }
}
