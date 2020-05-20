package thread_12.pool.callBack;

import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallbackExample {
    private ExecutorService executorService;

    public CallbackExample() {
        executorService = Executors.newFixedThreadPool(2);
    }   // constructor

    // callback 객체를 하나 생성한다.
    // 결과타입 : Integer, 첨부타입 : Void
    private CompletionHandler<Integer, Void> callback = new CompletionHandler<Integer, Void>() {
        @Override   // 작업 정상 완료시 호출
        public void completed(Integer result, Void aVoid) {
            System.out.println("completed() 실행 : " + result);
        }

        @Override   // 작업 중간에 exception 이 발생한 경우 호출됨
        public void failed(Throwable throwable, Void aVoid) {
            System.out.println("faild() 실행 " + throwable.toString());
        }
    };

    public void doWork(final String x, final String y) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    int intX = Integer.parseInt(x);
                    int intY = Integer.parseInt(y);
                    int result = intX + intY;
                    callback.completed(result, null);   // 정상 처리했을 경우 호출
                } catch (NumberFormatException e) {
                    callback.failed(e, null);           // 예외가 발생했을 경우 호출
                }
            }
        };  // Runnable
        executorService.submit(task);   // 스레드 풀에 작업 처리 요청
    }

    public void finish() {
        executorService.shutdown();     // 스레드 풀 종료
    }

    public static void main(String[] args) {
        CallbackExample example = new CallbackExample();
        example.doWork("3", "3");
        example.doWork("3", "삼");
        example.finish();
    }   // main
}
