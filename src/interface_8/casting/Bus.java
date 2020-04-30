package interface_8.casting;

public class Bus implements Vehicle {
    @Override
    public void run() {
        System.out.println("버스가 달립니다.");
    }

    // 추가 메소드
    public void checkFare() {
        System.out.println("승차요금을 체크합니다.");
    }
}
