package api_11.system.time;

// 컴퓨터의 시계로부터 현재시간을 읽어서 long 값으로 리턴된다.
// System.currentTimeMillis()   : ms 단위로 리턴한다.
// System.nanoTime()            : nano second 단위로 리턴된다.
// 일반적으론 프로그램 실행시간을 계산하는데 사용된다.

public class SystemTimeExample {
    public static void main(String[] args) {
        long time1 = System.nanoTime();     // 시작시간 읽기
        long time2 = System.currentTimeMillis();

        long sum = 0;
        for(int i = 1; i <= 10000000; i++) {
            sum += i;
        }

        long end_time1 = System.nanoTime();     // 끝 시간 읽기
        long end_time2 = System.currentTimeMillis();

        System.out.println("1 ~ 10000000까지의 합 : " + sum);
        System.out.println("계산에 " + (end_time1 - time1) + " 나노초가 소요되었습니다.");
        System.out.println("계산에 " + (end_time2 - time2) + " 밀리초가 소요되었습니다.");
    }
}
