package thread_12.synchronize.critical_section;

public class Calculator {
    private int memory;

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;           // 메모리에 값 저장 후
        try {
            Thread.sleep(2000);     // 2초간 기다린다.
        } catch(Exception e) {}

        System.out.println(Thread.currentThread().getName() + " : " + this.memory);
    }
}
