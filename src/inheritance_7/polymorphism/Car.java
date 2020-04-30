package inheritance_7.polymorphism;

public class Car {
    // field
    // 자동차는 4개의 타이어 객체를 가진다.
    Tire frontLeftTire = new Tire("앞왼쪽", 6);
    Tire frontRightTire = new Tire("앞오른쪽", 3);
    Tire backLeftTire = new Tire("뒤왼쪽", 5);
    Tire backRightTire = new Tire("뒤오른쪽", 4);

    // 위와같은 변수 선언을 배열을 이용해서 아래와 같이 만들 수 있다.
    Tire[] tires = {
            new Tire("앞왼쪽", 6),
            new Tire("앞오른쪽", 3),
            new Tire("뒤왼쪽", 5),
            new Tire("뒤오른쪽", 4)
    };


    // 모든 타이어를 1회 회전시키기 위해 각 Tire 객체의 roll()메소드를 호출한다.
    // false를 return하는 roll()이 있을 경우 stop() 메소드를 호출하고 해당 타이어 번호를 return 한다.
    int run() {
        System.out.println("자동차가 달립니다.");
        if(frontLeftTire.roll() == false)   { stop();   return 1; }
        if(frontRightTire.roll() == false)  { stop();   return 2; }
        if(backLeftTire.roll() == false)    { stop();   return 3; }
        if(backRightTire.roll() == false)   { stop();   return 4; }

        return 0;
    }

    // 배열로 만들었을 경우 아래와 같이 코드가 나온다.
    int run_array() {
        System.out.println("자동차가 달립니다.");
        for(int i = 0; i < 4; i++) {
            if(tires[i].roll() == false) {
                stop();
                return i + 1;
            }
        }
        return 0;
    }

    void stop() {
        System.out.println("[[ 자동차가 멈춥니다. ]]");
    }
}
