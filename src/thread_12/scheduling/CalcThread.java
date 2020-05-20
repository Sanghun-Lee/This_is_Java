package thread_12.scheduling;

// 20억번 loop를 돌고 thread 이름을 출력한 후 종료하는 class

public class CalcThread extends Thread {
    public CalcThread(String name) {
        setName(name);
    }

    @Override
    public void run() {
        for(int i = Integer.MIN_VALUE; i < 2000000000; i++) {
            // do nothing
        }
        System.out.println(getName());
    }
}
