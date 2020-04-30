package inheritance_7.override;

public class Computer extends Calculator{

    // Calculator 의 areaCircle() 메서드를 재정의하였다.
    @Override
    double areaCircle(double r) {
        System.out.println("Computer 객체의 areaCircle() 실행");
        return Math.PI * r * r;
    }

    // super 키워드를 이용해서 부모의 메서드를 호출할 수 있다.
    double compare(double r) {
        return areaCircle(r) - super.areaCircle(r); // 왼쪽은 override 된 메서드, 오른쪽은 부모클래스의 매서드를 호출한다.
    }
}
