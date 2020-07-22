#### 소켓 채널 데이터 통신

Client와 Server가 연결했다면, 양쪽 **SocketChannel**은 `read()`, `write()` 메소드를 호출해서 데이터 통신을 할 수 있다.

- 데이터 보내기

```java
Charset charset = Charset.forName("UTF-8");
ByteBuffer byteBuffer = charset.encode("Hello Server");
socketChannel.write(byteBuffer);
```

- 데이터 받기

```java
ByteBuffer byteBuffer = ByteBuffer.allocate(100);
int byteCount = socketChannel.read(byteBuffer);
byteBuffer.flip();
Charset charset = Charset.forName("UTF-8");
String message = charset.decode(byteBuffer).toString();
```