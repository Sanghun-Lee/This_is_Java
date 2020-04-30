package inheritance_7.polymorphism;

/*** 다형성의 이점에 대해서 살펴보자 ***/

// car.frontLeftTire 에 HankookTire의 값을 넣어서 자동 타입변환이 일어난다.
// 이제 car.run()함수를 돌리면 Override된 HankookTire의 roll() 메소드가 실행된다.
// 이처럼 car의 frontLeftTire의 타입은 Tire로 고정이지만, 거기에는 HankookTire객체 또는 KumhoTire개체 뭐든지 들어갈 수 있다.
// 그리고 Override를 통해서 같은 타입의 Tire라도, 다른 형태의 메소드를 호출할 수 있다.
// 이것이 바로 다형성이다. (같은 타입의 변수로 다른 메소드를 호출할 수 있다.)

public class CarExample {
    public static void main(String[] args) {
        Car car = new Car();    // car 객체 생성

        for(int i = 0; i < 5; i++) {
            int problemLocation = car.run();

            switch(problemLocation) {
                case 1:     // 앞쪽 타이어가 펑크나면 hankook타이어로 교체
                    System.out.println("앞왼쪽 HankookTire로 교체");
                    car.frontLeftTire = new HankookTire("앞왼쪽", 15);
                    // 교체되면서 자동 타입변환이 일어난다.
                    break;

                case 2:
                    System.out.println("앞오른쪽 KumhoTire로 교체");
                    car.frontRightTire = new KumhoTire("앞오른쪽", 20);
                    break;

                case 3:
                    System.out.println("뒤왼쪽 HankookTire로 교체");
                    car.backLeftTire = new HankookTire("뒤왼쪽", 14);
                    break;

                case 4:
                    System.out.println("뒤오른쪽 KumhoTire로 교체");
                    car.backRightTire = new KumhoTire("뒤오른쪽", 12);
                    break;
            }
            System.out.println("--------------------------------------------"); // 구분선
        }

        // 배열일 경우
        for(int i = 0; i < 7; i++) {
            int problemLocation = car.run_array();
            if(problemLocation != 0) {
                System.out.println(car.tires[problemLocation - 1].location + " HankookTire로 교체");
                car.tires[problemLocation - 1] = new HankookTire(car.tires[problemLocation - 1].location, 20);
            }
            System.out.println("--------------------------------------------"); // 구분선
        }
    }
}
