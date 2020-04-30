package inheritance_7.polymorphism;

public class KumhoTire extends Tire{
    // field
    // constructor
    public KumhoTire (String location, int maxRotation) {
        super(location, maxRotation);
    }

    // 출력 내용을 달리 하기 위해 override 한 roll 메소드
    @Override
    public boolean roll() {
        ++accumulatedRotation;
        if(accumulatedRotation < maxRotation) {
            System.out.println(location + " KumhoTire 수명 : " + (maxRotation - accumulatedRotation) + " 회");
            return true;
        }
        else {
            System.out.println("*** " + location + " KumhoTire 펑크 ***");
            return false;
        }
    }
}
