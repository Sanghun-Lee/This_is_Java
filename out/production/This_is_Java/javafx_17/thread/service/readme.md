#### Service 클래스

작업 스레드상에서 Task를 간편하게 `시작`, `취소`, `재시작` 할 수 있는 기능을 제공한다.

Task 객체는 `재사용이 불가능`하기 때문에 `Service`를 이용해서 `Task를 생성`한다.

> Service 생성

`Service는 추상 클래스` 이기 때문에, `Service를 상속`받고, `createTask()` 메소드를 `재정의` 하면 된다.

`createTask() 메소드`는 Task 생성 후, `Task<>를 리턴`하도록 만든다.

예시

```java
class CustomService extends Service<Integer> {
    @Override
    protected Task<Integer> createTask() {
        Task<Integer> task = new Task<Integer>() { /* ... */ };
        return task;
    }
}
```

> Service 시작, 취소, 재시작

- Service 시작 : `start()` 메소드
- Service 취소 : `cancel()` 메소드
- Service 재시작 : `restart()` 메소드

주의할 점은 해당 메소드들은 `JavaFx Application Thread` 상에서 호출해야 한다.

`start()`와 `restart()`가 호출되면 `createTask()`가 실행되고, 리턴된 Task를 받아 작업 스레드에서 실행한다.

> 작업 상태별 콜백

이는 task에서 살펴보았던 것과 동일하다.

| 콜백 메소드 | 설명 |
| --- | --- |
| succeeded() | 성공적으로 call() 메소드가 리턴되었을 때 |
| cancelled() | cancel() 메소드로 작업이 취소되었을 때 |
| failed() | 예외가 발생되었을 때 |