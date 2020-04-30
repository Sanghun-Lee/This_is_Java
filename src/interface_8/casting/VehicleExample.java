package interface_8.casting;

public class VehicleExample {
    public static void main(String[] args) {
        Vehicle vehicle = new Bus();        // 인터페이스 객체에 구현객체를 대입했다.

        vehicle.run();
        // vehicle.checkFare();     // Vehicle 인터페이스에는 checkFare 함수가 없어서 호출 불가능하다.

        Bus bus = (Bus)vehicle;     // 강제 타입 변환

        bus.run();
        bus.checkFare();            // Bus 클래스는 checkFare 메소드가 있어서 호출 가능하다.
    }
}
