package class_6.method;

public class Computer {
    /****** 클래스 내부의 메서드의 매개변수 인자의 갯수가 정해지지 않을 때 사용법 *******/

    // 1. 배열을 이용해서 넘겨준다.
    int sum1(int[] values) {
        int sum = 0;
        for(int i = 0; i < values.length; i++)
            sum += values[i];
        return sum;
    }

    // 2. "..." 연산자를 이용한다.
    int sum2(int ... values) {
        int sum = 0;
        for(int i = 0; i < values.length; i++)
            sum += values[i];
        return sum;
    }
}
