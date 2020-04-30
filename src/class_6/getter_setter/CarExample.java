package class_6.getter_setter;

public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car();

        // 잘못된 속도 변경 >> 그래도 0으로 저장된다.
        myCar.setSpeed(-50);

        System.out.println("현재 속도 : " + myCar.getSpeed());

        // 옳바른 속도 변경
        myCar.setSpeed(60);
        System.out.println("현재 속도 : " + myCar.getSpeed());

        if(!myCar.isStop())
            myCar.setStop(true);

        System.out.println("현재 속도 : " + myCar.getSpeed());
    }
}
