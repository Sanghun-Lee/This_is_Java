package interface_8.polymorphism;

public class HankookTire implements Tire {

    @Override
    public void roll() {
        System.out.println("한국타이어가 굴러갑니다.");
    }
}
