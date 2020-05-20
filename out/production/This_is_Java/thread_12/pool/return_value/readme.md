### 블로킹 방식의 작업 완료 통보

thread의 작업이 완료된 후, 결과를 return 받고 싶을 때 사용한다.

먼저 3가지 방식이 있다.

1. Future<?> submit(Runnable task)
    - 리턴타입이 없는 Thread 호출
    
2. Future<V> sumbit(Runnable task, V result)
    - Runnable로 task를 만든 후, task를 실행하고, 결과는 result에 들어간다.
  
3. Future<V> sumbit(Callable<V> task)


> Future 객체

Future 객체는 작업이 완료될 때 까지 기다렸다가(blocking 되었다가), 최종 결과를 얻는데 사용된다.

결과는 `future.get() // future : Future 객체 변수` get 메소드로 리턴값을 받을 수 있다.

3가지 방식에 따른 결과값

1. submit(Runnable task) - 리턴값이 없는 경우
    - future.get() -> null
    
2. submit(Runnable task, Integer result) - Runnable 로 리턴값을 만들려는 경우
    - future.get() -> int 타입 값
    
3. submit(Callable<String> task) - Callable 로 Thread를 만든 경우
    - future.get() -> String 타입 값
    
> <V> 에서 작성한 타입의 변수가 생성된다.


### 작업 처리 결과를 외부 객체에 저장

두 개 이상의 스레드 작업을 취합할 목적이 있을 땐, 작업 결과를 외부 객체에 저장해야 한다.

이 때 사용하는 메소드가

`executorService.submit(Runnable task, V result)` 이다.

Runnable의 구현객체를 만들 때, 생성자로 result 객체를 넣어주어야 한다.

```java
Result result = ...;
Runnable task = new Task(result);   // 생성자로 외부 객체를 넘겨준다.
Future<Result> future = executorService.submit(task, result);
result = future.get();
```