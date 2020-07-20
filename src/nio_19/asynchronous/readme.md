#### 파일 비동기 채널

FileChannel의 `read()`와 `write()` 메소드는 파일 입출력 작업동안 `블로킹` 된다.

만약 UI 및 이벤트 처리하는 스레드라면 데이터를 다 받을 때 까지 프로그램이 응답하지 않는다.

그래서 새로운 스레드를 생성한 후 코드를 처리해야 되는데, 이렇게 되면 파일의 수가 많아지면 스레드 수가 많아지는 문제가 생긴다.

그래서 `자바NIO`는 비동기 파일 채널을 별도로 제공하고 있다.

`AsynchronousFileChannel`은 read(), write()메소드를 호출하면

`스레드풀`에게 작업 처리를 요청하고 read() / write() 메소드를 `즉시 리턴` 시킨다.

그래서 실질적인 입출력 작업은 스레드풀의 작업 스레드가 담당한다.

작업 스레드가 작업을 완료하면 자동으로 `콜백(call back) 메소드`를 호출한다.

---

##### AsynchronousFileChannel 생성과 닫기

`open()`메소드로 생성할 수 있고, 매개변수로 `스레드풀`에 관한 설정을 할 수 있다.

```java
AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
    Path file,
    OpenOption... options
);
```

```java
AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
    Path file,
    Set<? extends OpenOption> options,
    ExecutorService executor,
    FileAttribute<?>... attrs
);
```

##### 파일 읽기와 쓰기

`read()`, `write()` 메소드를 활용해서 입출력 할 수 있다.

```java
read(ByteBuffer dst, long position, A attachment, CompletionHandler<Integer, A> handler);
write(ByteBuffer src, long position, A attachment, CompletionHandler<Integer, A> handler);
```

- dst, src : 읽거나 쓰기 위한 ByteBuffer
- position : 파일에서 읽을/쓸 위치
- attachment : 콜백 메소드로 전달할 첨부 객체 (콜백 메소드 매개변수)
- handler : 콜백 메소드, `completed()` 메소드와 `faild()` 메소드를 재정의 해야한다.

