package thread_12.state.control.wait.producer_and_consumer_problem;

public class DataBox {
    private String data;

    public synchronized String getData() {
        // 만약에 가져갈 데이터가 없다면 (소비자가 호출하는 메소드)
        if(this.data == null) {
            try {
                wait(); // 대기상태에 들어간다.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String returnValue = data;
        System.out.println("ConsumerThread 가 읽은 데이터 : " + returnValue);
        data = null;    // data 를 null 로 만들어 주고
        notify();       // 생산자 스래드를 실행 대기 상태로 만들어준다.
        return returnValue;
    }

    // 생산자가 호출할 메소드
    public synchronized void setData(String data) {
        // 만약에 이미 데이터가 채워져 있으면
        if(this.data != null) {
            try {
                wait(); // 실행대기 상태로 들어간다.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.data = data;
        System.out.println("Producer Thread 가 생성한 데이터 : " + data);
        notify();
    }
}
