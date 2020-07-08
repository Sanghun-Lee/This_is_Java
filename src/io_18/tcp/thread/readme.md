#### 스레드 병렬 처리

연결 수락을 위해 `ServerSocket`의 `accept()`를 실행하거나,

서버 연결 요청을 위해 `Socket`에서 `connect()`를 실행할 경우

해당 작업이 완료될 때 까지 `blocking`상태가 된다.

`InputStream`의 `read()`, `OutputStream`의 `write()` 메소드도 실행 시 왼료까지 `blocking`된다.

그렇기 때문에, `main함수` or `JavaFx Application Thread` 에서 blocking 될 경우 큰 문제가 될 수 있다.

그래서 `accept()`, `connect()`, `read()`, `write()` 메소드는 별도의 `작업 스레드`를 생성해서 그 곳에서 처리되어야 한다.

> thread의 생성

위에서 말한 것 처럼 blocking 메소드를 실행시에는 별도의 작업 스레드를 생성해서

해당 스레드에서 호출되도록 해야 한다.

만약에 엄청 많은 요청이 들어오면, 각 요청에 대해서 thread를 생성해, 과도하게 thread가 생성될 수 있다.

그래서 `thread pool`을 사용해서 구현하는것이 좋다.

accept() 메소드가 실행될 `Runnable interface`를 구현하고,

`thread pool(executorService)`에 `.submit()` 메소드로 요청 thread를 추가 해서, blocking 메소드의 요청을 처리해야 한다.