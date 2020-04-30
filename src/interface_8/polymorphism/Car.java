package interface_8.polymorphism;

public class Car {
    // 인터페이스 타입 필드 선언과 초기 구현 객체 대입
    Tire frontLeftTire = new HankookTire();
    Tire frontRightTire = new HankookTire();
    Tire backLeftTire = new HankookTire();
    Tire backRightTire = new HankookTire();

    // 인터페이스 배열로 객체들 관리하기
    Tire tires[] = {
            new HankookTire(),
            new HankookTire(),
            new HankookTire(),
            new HankookTire()
    };

    // 인터페이스에서 설명된 roll() 메소드 호출
    void run() {
        frontLeftTire.roll();
        frontRightTire.roll();
        backLeftTire.roll();
        backRightTire.roll();
    }

    // 인터페이스 배열로 run 함수 실행
    void run_array() {
        for(Tire tire : tires)
            tire.roll();
    }
}
