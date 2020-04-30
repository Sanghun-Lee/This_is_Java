package inheritance_7.polymorphism;

public class Tire {
    // field
    public int maxRotation;             // 최대 회전수(타이어 수명)
    public int accumulatedRotation;     // 누적 회전수
    public String location;             // 타이어의 위치

    // constructor
    public Tire (String location, int maxRotation) {
        this.location = location;
        this.maxRotation = maxRotation;
    }

    public boolean roll() {             // 타이어를 한 번 회전하고 수명이 다 되면 return false, 수명이 남았으면 return true
        ++accumulatedRotation;          // 누적 회전수 1 증가
        if(accumulatedRotation < maxRotation) {
            System.out.println(location + "Tire 수명 : " + (maxRotation - accumulatedRotation) + "회");
            return true;
        }
        else {
            System.out.println("*** " + location + " Tire 펑크 ***");
            return false;
        }
    }
}
