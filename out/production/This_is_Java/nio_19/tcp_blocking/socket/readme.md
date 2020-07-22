#### 서버소켓 채널과 소켓 채널의 용도

`NIO`에서 TCP 통신을 위해 사용하는 채널은 `java.nio.channels.ServerSocketChannel`과

`java.nio.channels.SocketChannel`이다.

ServerSocketChannel, SocketChannel은 `buffer`를 이용하고, `blocking`, `non-blocking` 모두 지원한다.

##### 서버 소켓 채널 생성과 연결 수락

- ServerSocketChannel 객체 생성
- `open()` 으로 생성한다.
- blocking을 위해 `configureBlocking(true)` 메소드를 호출한다.
- `bind` 메소드로 포트를 전달한다.

```java
ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
serverSocketChannel.configureBlocking(true);
serverSocketChannel.bind(new InetSocketAddress(5001));
```

그 후, `accept()` 메소드로 client가 연결 요청을 하기 전까지 blocking 된다.

```java
SocketChannel socketChannel = serverSocketChannel.accept();
```

연결된 client의 IP와 port 번호를 알고 싶다면 getRemoteAddress() 메소드로 얻을 수 있다.

연결 수락이 필요 없다면 `close()` 메소드를 호출해서 port를 unbinding 시켜야 한다.

```java
serverSocketChannel.close();
```

##### client 소켓 채널 생성 및 연결 요청

- SocketChannel의 `open()` 메소드로 객체를 생성
- blocking 방식을 위해 `configureBlocking(true)` 메소드 호출
- `connect()` 메소드 호출, 매개값으로 server의 `IP`와 `port`를 전달한다.

```java
SocketChannel socketChannel = SocketChannel.open();
socketChannel.configureBlocking(true);
socketChannel.connect(new InetSocketAddress("localhost", 5001));
```

close() 메소드로 자원을 반환한다.