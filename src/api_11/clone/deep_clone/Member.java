package api_11.clone.deep_clone;

// 깊은 복제
// 참조타입도 다르게 복제된다.
// 깊은 복제는 Object 의 clone() 메소드를 재정의해서 참조 객체를 복제하는 코드를 직접 작성해야 한다.

import java.util.Arrays;

public class Member implements Cloneable {
    public String name;
    public int age;
    public int[] scores;        // 참조 타입 필드
    public Car car;

    public Member(String name, int age, int[] scores, Car car) {
        this.name = name;
        this.age = age;
        this.scores = scores;
        this.car = car;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 먼저 얕은 복사를 해서 name, age 를 복제한다.
        Member cloned = (Member) super.clone();

        // scores 를 깊은 복제한다.
        cloned.scores = Arrays.copyOf(this.scores, this.scores.length);
        // car 를 깊은 복제한다.
        cloned.car = new Car(this.car.model);
        // 깊은 복제된 Member 객체를 리턴
        return cloned;
    }

    public Member getMember() {
        Member cloned = null;
        try {
            cloned = (Member) clone();  // 재 정의된 clone 메소드 호출
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return cloned;
    }

    public String arrayToString() {
        String str = "";
        for(int i : this.scores) {
            str = str + i + " ";
        }
        return "[ " + str + " ]";
    }
}
