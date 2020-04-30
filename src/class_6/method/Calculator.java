package class_6.method;

public class Calculator {
    /***** 클래스 내부에서 이미 생성한 메서드를 호출하기 위해선 그냥 함수 이름만 작성하면 된다. ******/
    int plus(int x, int y) {
        return x + y;
    }

    /*******    메서드 오버로딩    *******/
    // 함수의 반환형 or 매개변수의 type or 매개변수의 갯수
    // 위 셋중 하나라도 다르면 같은 이름의 함수를 여러개 만들 수 있다.
    double plus(double x, double y) {
        return x + y;
    }

    double avg(int x, int y) {
        double sum = plus(x, y);    // 같은 class 내부이기 때문에 그냥 메서드 이름만으로 호출 가능하다.
        double result = sum / 2;
        return result;
    }

    void execute() {
        double result = avg(7, 10);
        println("실행 결과 : " + result);   // 같은 class 내부이면 해당 메서드가 아래에 선언되어있어도 된다.
    }

    void println(String message) {
        System.out.println(message);
    }
}
