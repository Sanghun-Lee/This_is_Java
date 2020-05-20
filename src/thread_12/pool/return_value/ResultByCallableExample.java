package thread_12.pool.return_value;

// 리턴값이 있는 작업 완료 통보

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultByCallableExample {
    public static void main(String[] args) {
        // Thread pool 생성
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        System.out.println("[ 작업 처리 요청 ]");
        // return type이 있을 경우 Callable을 사용해서 thread pool에 추가한다.
        // Int type을 return 할 꺼라서 제너릭에 <Integer>를 작성했다.
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for(int i = 1; i <= 10; i++) { sum += i; }
                return sum;
            }
        };

        // Future도 type parameter가 Callable 의 제너릭과 같아야 한다.
        Future<Integer> future = executorService.submit(callable);

        try {
            int sum = future.get();
            System.out.println("[처리 결과 : " + sum + " ]");
            System.out.println("[ 작업 처리 완료 ]");
        } catch (Exception e) {
            System.out.println("[ 실행 예외 발생 ]" + e.getMessage());
        }

        executorService.shutdown();
    }   // main
}
