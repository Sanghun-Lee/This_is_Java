package class_6.static_;

public class CalculatorExample {
    public static void main(String[] args) {
        // static변수는 Class이름.static변수 이름 으로 접근한다.
        double result1 = 10 * 10 * Calculator.pi;

        // static 메서드도 class이름에 . 연산자를 이용해서 접근한다.
        int result2 = Calculator.plus(10, 20);
        int result3 = Calculator.minus(30, 15);

        System.out.println("result1 : " + result1);
        System.out.println("result2 : " + result2);
        System.out.println("result3 : " + result3);

        Calculator.Method3();
    }
}
