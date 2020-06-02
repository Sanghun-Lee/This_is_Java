package lambda_expression_14.api;

// Supplier : 매개 변수가 없고, 리턴값이 있는 getXXX() 메소드를 가진다.

// 주사위의 숫자를 랜덤하게 공급하는 IntSupplier 인터페이스를 타겟 타입으로 하는 람다식
// Supplier 함수적 인터페이스

import java.util.function.IntSupplier;

public class SupplierExample {
    public static void main(String[] args) {
        IntSupplier intSupplier = () -> {
            int num = (int) (Math.random() * 6) + 1;
            return num;
        };

        int num = intSupplier.getAsInt();
        System.out.println("눈의 수 : " +  num);
    }
}
