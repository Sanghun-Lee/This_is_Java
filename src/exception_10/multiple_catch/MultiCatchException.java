package exception_10.multiple_catch;

public class MultiCatchException {
    public static void main(String[] args) {
        try {
            String data1 = args[0];
            String data2 = args[1];

            int value1 = Integer.parseInt(data1);
            int value2 = Integer.parseInt(data2);
            int result = value1 + value2;
            System.out.println(data1 + " + " + data2 + " = " + result);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            // 하나의 catch 문에 | 연산자를 넣어서 두 개의 Exception 을 하나의 catch 에 모두 처리할 수 있다.
            System.out.println("실행 매개값의 수가 부족하거나 숫자로 변환할 수 없습니다.");
            return;
        } catch (Exception e) {
            System.out.println("알 수 없는 예외 발생.");
        } finally {
            System.out.println("다시 실행하세요");
        }
    }
}
