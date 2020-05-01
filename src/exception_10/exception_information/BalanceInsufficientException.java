package exception_10.exception_information;

// 사용자 정의 예외 만들기
// 1. 컴파일러가 체크하는 일반 예외 만들기       : extends Exception
// 2. 컴파일러가 체크하지 않는 일반 예외 만들기   : extends RuntimeException
// 필드, 생성자, 메소드 선언이 가능하지만, 일반적으론 생성자만 선언한다.
// 하나는 매개변수가 없는 생성자, 다른 하나는 String 타입의 매개변수를 갖는 생성자를 만든다.

public class BalanceInsufficientException extends Exception {
    public BalanceInsufficientException() {

    }

    public BalanceInsufficientException(String message) {
        super(message);
    }
}
