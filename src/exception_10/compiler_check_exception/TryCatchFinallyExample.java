package exception_10.compiler_check_exception;

// 일반 예외(컴파일러 체크 예외)를 처리하는 예시
// try - catch - finally 로 묶는다.

// Class.forName(매개값) : 매개값으로 주어진 클래스가 존재하면 Class 객체를 리턴한다.
// 존재하지 않으면 ClassNotFoundException 을 발생시킨다.

public class TryCatchFinallyExample {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("java.lang.String2");
        } catch (ClassNotFoundException e) {
            System.out.println("클래스가 존재하지 않습니다.");
        }
    }
}
