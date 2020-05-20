package thread_12.pool.completionService;

import java.util.concurrent.*;

public class CompletionServiceExample extends Thread {
    public static void main(String[] args) {
        // thread pool 생성
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // completionService 객체 생성
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executorService);

        System.out.println("[ 작업 처리 요청 ]");
        for(int i = 0; i < 3; i++) {
            completionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int sum = 0;
                    for(int i = 1; i <= 10; i++)
                        sum += i;
                    return sum;
                }
            });
        }

        System.out.println("[ 처리 완료된 작업 확인 ]");
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Future<Integer> future = completionService.take();  // 완료된 작업을 가져온다.
                        // take 메소드는 blocking 메소드 이기 때문에, 새로운 thread 에서 실행하도록 만든다.
                        int value = future.get();   // take에서 작업을 가져왔기 때문에, get은 blocking이 되지 않는다.
                        System.out.println("[ 처리 결과 : " + value + " ]");
                    } catch (Exception e) {
                        break;
                    }
                }
            }
        });

        // 3초 후 thread pool 종료 - 3초동안 처리가 되길 기다린다.
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
