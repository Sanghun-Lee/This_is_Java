package inheritance_7.abstract_;

public class PhoneExample {
    public static void main(String[] args) {
        // Phone phone = new Phone();   // Phone은 추상 클래스이기 때문에 인스턴스를 생성할 수 없다.

        SmartPhone smartPhone = new SmartPhone("hun");

        // 자식 클래스인 smartPhone을 이용해서 Phone 메소드인 turnOn, turnOff에 접근한다.
        smartPhone.turnOn();
        smartPhone.internet_search();
        smartPhone.turnOff();
    }
}
