package inheritance_7.polymorphism;

public class HankookTire extends Tire {
    // field
    // constructor
    public HankookTire (String location, int maxRotation) {
        super(location, maxRotation);
    }

    // 출력 내용을 달리 하기위해 override한 roll 메소드
    @Override
    public boolean roll() {
        ++accumulatedRotation;
        if(accumulatedRotation < maxRotation) {
            System.out.println(location + " HankookTire 수명 : " + (maxRotation - accumulatedRotation) + " 회");
            return true;
        }
        else {
            System.out.println("*** " + location + " HankookTire 펑크 ***");
            return false;
        }
    }
}
