package thread_12.scheduling;

// thread 우선순위 설정
// thread의 우선순위는 1 (낮음) ~ 10 (높음) 으로 설정할 수 있다.
// 10개의 thread를 생성 후
// 1 ~ 9번은 가장 낮은 우선순위를
// 10번은 가장 높은 우선순위를 둔 뒤에, 어느것이 가장 빨리 끝나는지 확인해 보자

public class PriorityExample {
    public static void main(String[] args) {
        for(int i = 1; i <= 10; i++) {
            Thread thread = new CalcThread("thread" + i);
            if(i != 10) {
                thread.setPriority(Thread.MIN_PRIORITY);    // Thread.MIN_PRIORITY : 1
            }
            else
                thread.setPriority(Thread.MAX_PRIORITY);    // Thread.MAX_PRIORITY : 10
            thread.start();
        }
    }
}
