package thread_12.pool;

import java.util.concurrent.*;

public class ExecuteExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);  // 최대 스레드 개수가 2개인 스레드 풀 생성
        // ExecutorService executorService1 = new ThreadPoolExecutor(3, 100, 120L, TimeUnit.SECONDS, new SynchronousQueue<>())

        for(int i = 0; i < 10; i++) {
            // 작업 정의
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    // 스레드 총 개수 및 작업 스레드 이름 출력
                    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
                    int poolSize = threadPoolExecutor.getPoolSize();

                    String threadName = Thread.currentThread().getName();
                    System.out.println("[ 총 스레드 갯수 : " + poolSize + " ] 작업 스레드 이름 : " + threadName);
                    // 예외를 발생시킨다.
                    int value = Integer.parseInt("삼");
                }
            };

            // 작업 처리 요청
            executorService.submit(runnable);
            // executorService.execute(runnable);

            Thread.sleep(10);
        }
        executorService.shutdown(); // 스레드 풀 종료
    }
}
