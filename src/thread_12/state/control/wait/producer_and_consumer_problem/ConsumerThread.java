package thread_12.state.control.wait.producer_and_consumer_problem;

public class ConsumerThread extends Thread {
    private DataBox dataBox;

    public ConsumerThread(DataBox dataBox) {
        this.dataBox = dataBox;     // 공유 객체를 필드에 저장
    }

    @Override
    public void run() {
        for(int i = 0; i < 3; i++) {
            String data = dataBox.getData();        // 새로운 데이터를 읽는다.
            System.out.println("Consumer가 읽은 데이터 : " + data);
        }
    }
}

