package class_6.constructor;

public class Car {
    // field : 해당 class내부에서 사용할 변수
    String company = "현대자동차";   // 왼쪽과 같은 방법으로 클래스 내부의 필드를 초기화 할 수 있다.
    String model;
    String color;
    int maxSpeed;

    /*****  여러개의 생성자를 생성한다. >> 생성자 오버로딩 *****/
    /*****  생성자를 호출할 때 this.xxx = xxx 라는 코드가 중복이 된다. >> this를 이용해서 다른 생성자를 호출 할 수 있다. *****/
    // 기본 생성자
    Car() {
        // ... 아무일도 하지 않는다.
    }

    // 매개변수가 한개인 생성자
    Car(String model) {
        // this.model = model;
        this(model, "", 0); // 매개변수가 3개인 생성자를 호출
    }

    // 매개변수가 두 개인 생성자
    Car(String model, String color) {
        // this.model = model;
        // this.color = color;
        this(model, color, 0);  // 위 두 줄을 this를 이용해서 한 줄로 만들 수 있다.
        // 위와같이 작성하면 매개변수가 3개인 생성자를 호출하게 된다.
    }

    // 매개변수가 세 개인 생성자
    Car(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}
