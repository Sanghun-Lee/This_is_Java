package class_6.constructor;

// main함수가 오는 class
// 같은 package의 Car 클래스를 사용한다.
public class CarExample {
    public static void main(String[] args) {
        // new 연산자로 class 생성
        Car car1 = new Car();   // Car class중 기본 생성자로 클래스를 생성한다.
        System.out.println("car1.company : " + car1.company + "\n");

        Car car2 = new Car("자가용");  // 매개변수가 1개인 생성자로 클래스를 생성한다.
        System.out.println("car2.company : " + car2.company);
        System.out.println("car2.model : " + car2.model + "\n");

        Car car3 = new Car("자가용", "빨강");    // 매개변수가 2개인 생성자로 클래스를 생성한다.
        System.out.println("car3.company : " + car3.company);
        System.out.println("car3.model : " + car3.model);
        System.out.println("car3.color : " + car3.color + "\n");

        Car car4 = new Car("택시", "검정색", 200);  // 매개변수가 3개인 생성자로 클래스를 생성한다.
        System.out.println("car4.company : " + car4.company);
        System.out.println("car4.model : " + car4.model);
        System.out.println("car4.color : " + car4.color);
        System.out.println("car4.maxSpeed : " + car4.maxSpeed + "\n");
    }
}