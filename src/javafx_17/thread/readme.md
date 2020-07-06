### 17.11 스레드 동시성

> 3줄 요약
>
> UI변경은 JavaFx Application Thread 에서만 담당하고 있다.
>
> Thread.sleep(x)와 같은 기다려야되는 작업은 새로운 작업 스레드를 생성해야 한다.
>
> 작업 스레드에서 UI 변경 시, Platform.runLater() or Task or Service를 이용한다.

JavaFx UI는 스레드에 안전하지 않기 때문에

UI를 변경하는 작업은 JavaFx Application Thread만 담당하고 있다.

그래서 다른 작업 스레드들은 UI를 생성하거나 변경할 수 없다.

main 스레드가 Application의 launch 메소드를 실행하면서 생성된

`JavaFx Application Thread`는 `start() 메소드`에서모든 UI를 처리한다.

<strong>여기서 주의할 점은</strong>

`JavaFx Application Thread`가 시간을 요하는 작업을 하지 않도록 해야 한다.

시간을 요하는 작업이란, `파일을 읽거나`, `Thread.sleep(x)` 과 같은 메소드를 말한다.

JavaFx Application Thread가 시간을 요하는 작업을 하는 경우, 시간이 다 될때 까지

UI변경이 안되기 때문에, 반드시 `작업 스레드를 생성해서 처리`해야 한다.

작업 스레드가 UI변경이 필요한 경우

- `Platform.runLater()` 메소드와

- `Task` or `Service`를 이용해서 해결한다.

| 챕터 | 패키지 | 설명 |
| --- | ---- | ---- |
| 17.11.1 | run_later | Platform.runLater() 메소드 |
| 17.11.2 | task | Task 클래스 |
| 17.11.3 | service | Service 클래스 |