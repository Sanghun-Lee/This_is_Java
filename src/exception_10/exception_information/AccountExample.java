package exception_10.exception_information;

// 예외 정보 얻기
// 1. getMessage()
// 2. printStackTrace()

// 예외를 생성할 때 매개변수가 String type 인 생성자를 만들었다면
// 예외가 발생할 때 메시지는 자동적으로 예외 객체 내부에 저장된다.
// 해당 메시지는 catch 블록 내에서 getMessage() 메소드로 리턴받을 수 있다.

public class AccountExample {
    public static void main(String[] args) {
        Account account = new Account();

        // 예금하기
        account.deposit(10000);
        System.out.println("예금액 : " + account.getBalance());

        // 출금하기
        try {
            account.withdraw(30000);
        } catch (BalanceInsufficientException e) {
            String message = e.getMessage();        // 예외 메시지 얻기
            System.out.println(message);            // "잔고부족 xxx원 모자람" 이 출력된다.
            System.out.println();

            e.printStackTrace();                    // 예외 추적 후 출력 - 예외가 최초로 발생한 파일의 line 수 까지 나온다.
        }
    }
}
