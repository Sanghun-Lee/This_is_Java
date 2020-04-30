package inheritance_7.polymorphism.parameter;

// 자식클래스
public class Bus extends Vehicle {
    @Override
    public void run() {
        System.out.println("버스가 달립니다.");
    }
}
