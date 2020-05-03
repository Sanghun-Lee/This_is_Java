package api_11.finalize;

// finalize 객체 소멸자
// Garbage Collector 는 객체를 소멸하기 직전에 마지막으로 객체 소멸자 finalize() 메소드를 실행시킨다.
// 객체가 소멸하기 전에 사용했던 자원 (socket, file IO) 등을 닫고 싶거나, 중요한 데이터를 저장하고 싶다면
// finalize() 메소드를 재정의 할 수 있다.

public class Counter {
    private int no;

    public Counter(int no) {
        this.no = no;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(no + "번 객체의 finalize()가 실행됨");
    }
}
