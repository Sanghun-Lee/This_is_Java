package exception_10.exception_information;

// 예외 발생시키는 방법
// 1. throw new ...Exception(); or
// 2. throw new ...Exception(message);

public class Account {
    private long balance;
    public Account() {

    }

    public long getBalance() {
        return balance;
    }

    public void deposit(int money) {
        balance += money;
    }

    // 예외 떠넘기기 (throws)
    public void withdraw(int money) throws BalanceInsufficientException {
        if(balance < money) {
            // 사용자 정의 예외를 발생시킨다.
            throw new BalanceInsufficientException("잔고 부족 : " + (money - balance) + " 모자람");
        }
        balance -= money;
    }
}
