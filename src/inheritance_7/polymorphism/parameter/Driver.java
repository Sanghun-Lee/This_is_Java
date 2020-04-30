package inheritance_7.polymorphism.parameter;

// Vehicle 을 매개변수로 사용하는 메서드가 있는 클래스
public class Driver {
    // Vehicle 클래스변수를 매개변수로 받아서 Vehicle 이 가지고있는 run 메소드를 호출한다.
    public void drive(Vehicle vehicle) {
        vehicle.run();
    }
}
