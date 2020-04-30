package interface_8.casting;

public class Driver {
    // 매개변수를 인터페이스로 넣었다.
    // 그래서 매개변수로 어떤 구현 객체가 와도 해당 구현객체에서 Override 된 run 함수가 실행된다.
    public void drive(Vehicle vehicle) {
        vehicle.run();

        // VehicleExample 에서 Vehicle 을 Bus 로 강제 타입변환 했는데, 해당 메소드 같은 경우
        // Vehicle 을 구현한 모든 구현 객체가 올 수 있기 때문에 Bus 로 강제변환 하기 위해선 미리 확인하는 작업이 필요하다 >> instanceof

        if(vehicle instanceof Bus) {    // 인터페이스가 Bus 의 구현객체를 받았는지 확인
            Bus bus = (Bus) vehicle;    // 받았으면 강제 형 변환을 실시한다.
            bus.checkFare();
        }
    }
}
