package exception_10.compiler_check_exception;

public class TryCatchFinallyRuntimeException {
    public static void main(String[] args) {
        String data1 = null;
        String data2 = null;

        try {
            data1 = args[0];
            data2 = args[1];
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("실행 매개값의 수가 부족합니다.");
            System.out.print("[ 실행 방법 ]");
            System.out.print("java TryCatchFinallyRuntimeException num1 num2");
            return;
        }

        try {
            int value1 = Integer.parseInt(data1);   // 여기서 data1이 int 형으로 바꿀 수 있는지 확인
            int value2 = Integer.parseInt(data2);   // 여기도 똑같이 확인, 만약에 바꿀 수 없으면
            int result = value1 + value2;           // NumberFormatException 을 발생시키고 아래 catch 문이 실행된다.
            System.out.println(data1 + " + " + data2 + " = " + result);
        } catch(NumberFormatException e) {
            System.out.println("숫자로 변환할 수 없습니다.");
        } finally {
            System.out.println("다시 실행하세요");
        }
    }
}
