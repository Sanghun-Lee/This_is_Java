package interface_8.casting;

// 매개변수의 다형성 테스트
public class DriverExample {
    public static void main(String[] args) {
        Driver driver = new Driver();

        Bus bus = new Bus();
        Taxi taxi = new Taxi();

        driver.drive(bus);      // Bus 클래스의 Override 된 run 함수를 실행한다.
        driver.drive(taxi);     // Taxi 클래스의 Override 된 run 함수를 실행한다.
    }
}
