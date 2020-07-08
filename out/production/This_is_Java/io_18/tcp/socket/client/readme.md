#### Socket 생성과 연결 요청 (client)

> 객체 생성 및 bind

```java
try {
    Socket socket = new Socket("ip address", 5001); // 첫 번째 방법
    Socket socket = new Socket(new InetSocketAddress("ip address", 5001));  // 두 번째 방법
} catch(UnknownHostException e) {
    // IP 표기 방법이 잘못 되었을 경우
} catch(IOException e) {
    // 해당 포트의 서버에 연결할 수 없는 경우
}
```

> 외부 server와 연결

`connect`메소드를 이용해서 server와 연결한다.

```java
socket = new Socket();
socket.connect(new InetSocketAddress("ip address", 5001));
```

`connect`메소드는 서버와 연결될 때 까지 `blocking` 상태가 된다.

> 연결 종료

`close()`메소드로 종료한다.

`IOException` 예외 처리가 필요하다.

```java
try {
    socket.close();
} catch(IOException e) {}
```