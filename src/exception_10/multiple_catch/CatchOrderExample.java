package exception_10.multiple_catch;

public class CatchOrderExample {
    public static void main(String[] args) {
        try {
            String data1 = args[0];
            String data2 = args[1];

            int value1 = Integer.parseInt(data1);
            int value2 = Integer.parseInt(data2);
            int result = value1 + value2;
            System.out.println(data1 + " + " + data2 + " = " + result);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("실행 매개값의 수가 부족합니다.");
            System.out.print("[ 실행 방법 ]");
            System.out.print("java TryCatchFinallyRuntimeException num1 num2");
            return;
        } catch (Exception e) {
            /*** Exception e 는 모든 예외들을 다 처리하기 때문에, ArrayIndex...Exception 위에 있으면 ArrayIndex...Exception 은 실행이 안된다. ***/
            // 왜냐하면 try 에서 Exception 이 발생하면 위에서부터 catch 의 Exception 들을 확인하는데 Exception e 는 모든 Exception 들을 다 모으기 때문에
            // ArrayIndex...Exception 까지 오지 않기 때문이다.
            // 그래서 *** 상위 예외 클래스가 하위 예외 클래스보다 아래쪽에 있어야 한다. ***
            System.out.println("숫자로 변환할 수 없습니다.");
        } finally {
            System.out.println("다시 실행하세요");
        }
    }
}
