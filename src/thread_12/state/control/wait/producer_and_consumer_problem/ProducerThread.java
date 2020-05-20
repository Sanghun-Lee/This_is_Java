package thread_12.state.control.wait.producer_and_consumer_problem;

public class ProducerThread extends Thread {
    private DataBox dataBox;

    public ProducerThread(DataBox dataBox) {
        this.dataBox = dataBox;
    }

    @Override
    public void run() {
        for(int i = 0; i < 3; i++) {
            String data = "Data - " + i;
            dataBox.setData(data);
        }
    }
}
