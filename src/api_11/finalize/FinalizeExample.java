package api_11.finalize;

// finalize() 메소드는 언제 호출될 지 모르기 때문에 프로그램이 종료될 때, 명시적으로 자원 해제 메소드를 호출해 두는것이 좋다.

public class FinalizeExample {
    public static void main(String[] args) {
        Counter counter = null;
        for(int i = 0; i < 50; i++) {
            counter = new Counter(i);

            counter = null;     // Counter 객체를 쓰래기로 만든다.

            System.gc();        // Garbage Collector 실행 요청
        }
    }
}
