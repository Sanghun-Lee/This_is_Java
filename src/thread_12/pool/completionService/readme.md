### CompletionService

작업 처리 결과를 외부 객체에 저장 할 때, 여러 thread 가 실행된다.

이 때 먼저 끝난 thread 의 작업을 받고 싶을 경우

`CompletionService` 객체를 이용해서 받으면 된다.

즉 작업 완료 순으로 통보 받을 수 있다.

메소드는 5가지가 있다.

1. Future<V> poll()
    - 완료된 작업의 Future를 가져온다.
    - 완료된 작업이 없으면 즉시 null을 리턴한다. (non-blocking)
    
2. Future<V> poll(long timeout, TimeUnit unit)
    - 완료된 작업의 Future를 가져온다.
    - 완료된 작업이 없으면 timeout 까지 기다린다. (blocking)
    
3. Future<V> take()
    - 완료된 작업의 Future를 가져온다.
    - 완료된 작업이 없으면 기다린다. (blocking)
    
4. submit(Callable<V> task)
    - 설명 생략

5. submit(Runnable task, V result)
    - 설명 생략

> 2, 3번은 blocking method 이기 때문에 새로운 thread에서 실행하는 것이 바람직하다.
    
위 메소드를 쓰기 위해선

thread pool에 thread를 넣을 때 completionService 객체에 넣어야 한다.

```java
// ... thread pool 생성완료

CompletionService<V> completionService = new ExecutorCompletionSercive<V>(executorService);

completionService(Callable<V> task);
completionService(Runnable task, V result);
```
