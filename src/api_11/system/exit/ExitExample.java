package api_11.system.exit;

// 프로그램 종료 exit 메소드
// System.exit(int number) 가 실행되면 checkExit(int number) 메소드가 실행된다.
// 이 checkExit 메소드가 정상종료되면 JVM 도 종료된다.
// 만약 종료시의 number 값을 제한하고 싶으면 보안 관리자 설정에서 checkExit(int number)를 재정의 한 뒤,
// SecurityException 을 throw 하면 checkExit 메소드가 종료되지않아서 프로그램은 종료되지 않는다.

// System 의 모든 메소드와 필드들은 static 으로 선언되어있다.

public class ExitExample {
    public static void main(String[] args) {
        // 보안 관리자 설정
        System.setSecurityManager(new SecurityManager() {
            @Override
            public void checkExit(int status) {
                if(status != 5) {                   // exit 번호가 5가 아니면
                    throw new SecurityException();  // 예외를 발생시켜서 프로그램 종료가 되는것을 막는다.
                }
            }
        });

        for(int i = 0; i < 10; i++) {
            // i값 출력
            System.out.println(i);
            try {
                // JVM 종료요청
                System.exit(i);
            } catch (SecurityException e) {}
        }
    }
}
