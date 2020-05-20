package thread_12.pool.return_value;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultByRunnableExample {
    public static void main(String[] args) {
        // thread pool 생성
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        System.out.println("[ 작업 처리 요청 ]");
        class Task implements Runnable {
            Result result;
            Task (Result result) {      // 외부 result 객체를 필드에 저장
                this.result = result;
            }

            @Override
            public void run() {
                int sum = 0;
                for(int i = 1; i <= 10; i++) {
                    sum += i;
                }
                result.addValue(sum);   // 외부 result 객체에 작업 결과를 저장
            }
        }   // Task class

        Result result1 = new Result();
        Runnable task1 = new Task(result1);
        Runnable task2 = new Task(result1); // 두 가지 작업 처리 요청을 위한 변수
        Future<Result> future1 = executorService.submit(task1, result1);
        Future<Result> future2 = executorService.submit(task2, result1);
        // 여기까지 두 가지 작업 처리를 요청한다.
        // 같은 객체를 지칭하는 것을 두 개의 thread로 실행한다.

        try {
            result1 = future1.get();    // future1이 실행되면서 result1 객체에 1 ~ 10까지 더한 결과가 처음으로 들어가고
            // 여기까지는 result1에 task1의 결과만 저장된다.
            result1 = future2.get();    // future2가 실행되면서 result1 객체에 1 ~ 10까지 더한 결과가 두 번째로 들어가서, 그 결과를 저장한 result1 객체가 리턴된다.
            System.out.println("[ 처리 결과 ] : " + result1.accumulatedValue);
            System.out.println("[ 작업 처리 완료 ]");
        } catch (Exception e) {
            System.out.println("[ 실행 예외 발생함 ] " + e.getMessage());
        }

        executorService.shutdown();
    }   // main
}

class Result {
    int accumulatedValue;
    synchronized void addValue(int value) {
        accumulatedValue += value;
    }
}