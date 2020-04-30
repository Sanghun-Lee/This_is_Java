package interface_8.polymorphism;

public class CarExample {
    public static void main(String[] args) {
        Car car = new Car();

        car.run();

        car.frontRightTire = new KumhoTire();
        car.frontLeftTire = new KumhoTire();

        car.run();
        //////////////
        System.out.println("-------------");

        car.run_array();

        // 인터페이스 배열로 사용하면 일반 배열에 접근하는 것 처럼 0, 1, 2, 3... 으로 만들 수 있다.
        car.tires[1] = new KumhoTire();
        car.tires[2] = new KumhoTire();

        car.run_array();
    }
}
