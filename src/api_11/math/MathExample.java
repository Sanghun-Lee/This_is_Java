package api_11.math;

// Math.something_method() 를 이용해서 자바에서 지원하는 수학 메소드를 호출할 수 있다.
// Math.abs(int or double) : 절댓값
// Math.ceil(double) : 올림
// Math.floor(double) : 내림
// Math.max(int, int) / Math.max(double, double) : 최댓값
// Math.min(int, int) / Math.min(double, double) : 최솟값
// Math.random() : 랜덤값 (0 ~ 1)
// Math.rint(double) : 가까운 정수의 실수값
// Math.round(double) : 반올림값

public class MathExample {
    public static void main(String[] args) {
        int v7 = Math.max(7, 9);
        System.out.println("v7 : " + v7);
        double v11 = Math.random();
        System.out.println("v11 : " + v11);

        double v12 = Math.rint(5.3);
        double v13 = Math.rint(5.7);
        System.out.println("v12 : " + v12);
        System.out.println("v13 : " + v13);

        // 소수 셋째 자릿수에서 반올림하는 코드
        double value = 12.3456;
        double temp = value * 100;
        long temp2 = Math.round(temp);
        value = temp2 / 100.0;
        System.out.println("v16 : " + value);
    }
}
