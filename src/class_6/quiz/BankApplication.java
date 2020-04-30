package class_6.quiz;

import java.util.Scanner;

public class BankApplication {
    private static Account[] accounts = new Account[100];
    private static Scanner sc = new Scanner(System.in);
    private static int length = 0;

    public static void main(String[] args) {
        boolean run = true;
        while(run) {
            System.out.println("------------------------------------------------------");
            System.out.println("1. 계좌 생성 | 2. 계좌 목록 | 3. 예금 | 4. 출금 | 5. 종료");
            System.out.println("------------------------------------------------------");
            System.out.print("선택 : ");

            int selectNo = sc.nextInt();
            sc.nextLine();

            switch(selectNo) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    accountList();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    withdraw();
                    break;
                case 5:
                    run = false;
                    break;
            }
        }
        System.out.println("프로그램 종료");
    }

    // 계좌 생성하기
    private static void createAccount() {
        String ano;
        String owner;
        int balance;

        System.out.println("---------------");
        System.out.println("계좌생성");
        System.out.println("---------------");

        System.out.print("계좌번호 : ");
        ano = sc.nextLine();
        System.out.print("계좌주 : ");
        owner = sc.nextLine();
        System.out.print("초기 예금액 : ");
        balance = sc.nextInt();

        accounts[length++] = new Account(ano, owner, balance);
        System.out.println("결과 : 계좌가 생성되었습니다.");
    }

    // 계좌 목록 보기
    private static void accountList() {
        System.out.println("---------------");
        System.out.println("계좌목록");
        System.out.println("---------------");
        for(Account ac : accounts) {
            if(ac == null)
                break;
            System.out.println(ac.getAno() + "\t" + ac.getOwner() + "\t" + ac.getBalance());
        }
    }

    // 예금하기
    private static void deposit() {
        System.out.println("---------------");
        System.out.println("예금");
        System.out.println("---------------");

        String ano;
        int balance;

        System.out.print("계좌번호 : ");
        ano = sc.nextLine();
        System.out.print("예금액 : ");
        balance = sc.nextInt();

        if(balance < 0) {
            System.out.println("실패 : 예금액은 0보다 커야 됩니다.");
            return;
        }

        Account account = findAccount(ano);
        if(account == null) {
            System.out.println("실패 : 일치하는 계좌번호가 없습니다.");
            return;
        }

        int bal = account.getBalance();
        account.setBalance(bal + balance);

        System.out.println("결과 : 예금이 성공되었습니다.");
    }

    // 출금하기
    private static void withdraw() {
        System.out.println("---------------");
        System.out.println("출금");
        System.out.println("---------------");

        String ano;
        int balance;

        System.out.print("계좌번호 : ");
        ano = sc.nextLine();
        System.out.print("출금액 : ");
        balance = sc.nextInt();

        Account account = findAccount(ano);

        if(account == null) {
            System.out.println("실패 : 일치하는 계좌번호가 없습니다.");
            return;
        }

        int ori_bal = account.getBalance();
        if(ori_bal < balance) {
            System.out.println("실패 : 입금액 보다 큰 금액을 인출할 순 없습니다.");
            return;
        }

        ori_bal -= balance;
        account.setBalance(ori_bal);
        System.out.println("결과 : 출금이 성공되었습니다.");
    }

    // Account 배열에서 ano와 동일한 Account 찾기
    private static Account findAccount(String ano) {
        Account ans = null;

        for(Account tmp : accounts) {
            if(tmp == null)
                break;

            if(tmp.getAno().equals(ano) == true) {
                ans = tmp;
            }
        }

        return ans;
    }
}
