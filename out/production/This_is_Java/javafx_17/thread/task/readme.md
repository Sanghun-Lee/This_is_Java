#### 17.11.2 Task 클래스

javafx.concurrent 패키지에선 스레드 동시성 API를 제공하고 있다.

해당 패키지는 인터페이스인 `Worker`와 구현 클래스인 `Task`, `Service`로 구성되어 있다.

```
Task 클래스는 JavaFx 애플리케이션에서 비동기 작업을 표현한 클래스이고,

Service는 이러한 Task를 간편하게 시작, 취소, 재시작 할 수 있는 기능을 제공한다.
```

이번 패키지에서는 `Task`에 대해서 살표보도록 하자.

---

##### Task

> Task 생성

Task는 작업 스레드에서 실행되는 하나의 작업을 표현한 추상 클래스 이다.

하나의 작업을 정의할 때에는 `Task`를 상속해서 클래스를 생성한 후, `call()` 메소드를 재정의 하면 된다.

`call()` 메소드의 리턴값을 Task의 제네릭 타입으로 설정하면 된다.

```java
Task<Integer> task = new Task<Integer>() {
    @Override
    protected Integer call() throws Exception {
        int result = 0;
        // 작업 코드 ...
        return result;
    }
}
```

리턴값이 없으면 타입 파라미터를 `Void`로 설정할 수 있다.

> Task 실행

작업 스레드를 생성할 때, `매개변수로 Task 객체`를 전달하면 된다.

```java
Task<Integer> task = new Task<Integer>() { ... };
Thread thread = new Thread(task);
thread.setDaemon(true);
thread.start();
```

`스레드 풀`에서 작업 스레드를 처리하려면 `ExecutorService`의 `submin()` 메소드를 호출할 때 매개값으로 전달하면 된다.

```java
Task<Integer> task = new Task<Integer>() { ... };
executorService.submit(task);
```

> Task 취소

Task는 `cancel()` 메소드가 호출되면 실행을 멈출 수 있어야 한다.

`cancel()` 메소드가 호출되면 `isCancelled()` 메소드에서 `true가 return`되는데,

이를 이용해서 작업을 종료해야 한다.

```java
Task<Void> task = new Task<Void>() {
    @Override
    protected Void call() throws Exception {
        while(...) {
            if(isCancelled()) { break; }
            // 작업 코드
        }
        return null;
    }
}
```

또한, Task가 `Thread.sleep()`과 같이 `블로킹`이 있을 때 cancel() 메소드 호출 시

`InterruptedException`이 발생한다. 그래서 블로킹이 있을때도 예외처리 해 주어야 한다.

```java
try { Thread.sleep(100); } catch (InterruptException interrupted) {
    if(isCancelled()) { break; }
}
```

