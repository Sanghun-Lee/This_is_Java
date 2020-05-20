### Thread pool

스레드 풀

스레드를 일정 갯수만큼만 생성하고

작업은 작업 큐에 넣은 후, 이미 생성된 thread 가 작업큐의 작업을 가져와서 실행하는 방식이다.

> Thread pool create
```java
// 최대 Integer.MAX_VALUE 개 만큼 생성할 수 있는 Thread pool 생성
ExecutorService executorService = Executors.newCachedThreadPool();

// nThreads 개 만큼만 thread 를 생성하는 Thread Pool 생성
ExecutorService executorService = Executers.newFixedThreadPool(int nThreads);

// Thread pool 직접 생성
ExecutorService threadPool = new ThreadPoolExecutor(
    int CoreThreadNum,  // 코어 스레드 갯수
    int MaxThreadNum,   // 최대 스레드 갯수
    long time,          // 놀고 있는 시간
    TimeUnit.SECONDS,   // 놀고 있는 시간 단위
    new SynchronousQueue<Runnable>()    // 작업 큐
);
```

> Thread Pool Close
```java
executorService.shutdown(); // 작업 큐의 모든 작업을 처리한 후, 스레드 풀 종료
executorService.shutdownNow();  // interrupt로 즉시 종료
```

> Thread Process create

1. Runnable 구현 클래스 (리턴값이 없다.)
2. Callable 구현 클래스 (리턴값이 있다.)

그 후, `execute(Runnable command)` or `submit(Runnable or Callable)` 로 작업 큐에 작업을 추가한다.

execute와 submit의 차이첨

1. execute는 작업 결과를 받지 못한다. submit은 작업 결과를 받는다.
2. interrupt 시에 execute() 는 스레드를 종료하고, submit은 thread를 종료하지 않고, 다음 작업을 위해 재사용한다.

그래서 안전을 위해 submit을 더 우선적으로 사용한다.
(ExecuteExample.java)