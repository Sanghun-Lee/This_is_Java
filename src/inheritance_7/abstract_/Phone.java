package inheritance_7.abstract_;

/*** 추상 클래스 (abstract) ***/

// 추상 클래스는 실체간에 공통된 특성을 추출한 것이다.
// 객체를 직접 생성할 수 있는 클래스를 실체 클래스 라고 한다면 해당 클래스들의 공통적인 특성을 추출해서 선언한 클래스를 추상클래스라 한다.

// 추상클래스는 실체 클래스들의 공통되는 필드와 메소드를 추출해서 만들었기 때문에 객체를 직접 생성해서 사용할 수 없다.
// 즉 추상 클래스는 new 연산자를 이용해서 인스턴스를 생성할 수 없다.

// 추상클래스의 용도
// 1. 실체 클래스들의 공통된 필드와 메소드의 이름을 통일할 목적
// 2. 실체 클래스를 작성할 때 시간을 절약한다.

public abstract class Phone {
    // field
    public String owner;

    // constructor
    public Phone(String owner) {
        this.owner = owner;
    }

    // method
    public void turnOn() {
        System.out.println("폰 전원을 켭니다.");
    }

    public void turnOff() {
        System.out.println("폰 전원을 끕니다.");
    }
}
