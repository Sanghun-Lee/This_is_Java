package basic;

/**
 * 기본 변수
 * primitive type variable
 */

public class Variable {
    public static void main(String[] args) {
        // 10을 변수 value의 초기값으로 설정
        int value = 10;

        int num1 = 123456780;
        int num2 = 123456780;

        float num3 = (float)num1;
        num1 = (int)num3;

        System.out.println(num1 - num2);

        int result = value + 10;
        System.out.println(result);
    }
}
