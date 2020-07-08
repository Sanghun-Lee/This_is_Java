#### ServerSocket 생성과 연결 수락

먼저 서버 개발을 하려면 ServerSocket 객체를 얻어야 한다.

그리고 이와 동시에 포트 번호에 `bind` 할 수 있다.

> 객체 생성 및 port bind

```java
// 첫 번째 방법, 생성과 동시에 bind
ServerSocket serverSocket = new ServerSocket(5001); // port number 전달

// 두 번째 방법, bind() 메소드로 bind
ServerSocket serverSocket = new ServerSocket();
serverSocket.bind(new InetAddress(5001));

// 세 번째 방법, ip address와 port 번호 bind
serverSocket.bind(new InetAddress("ip address", 5001));
```

해당 포트가 이미 사용중이면 `BindException`이 발생한다.

> accept()

ServerSocket은 `accept()`메소드로 클라이언트의 연결 요청을 기다린다.

`accept()` 메소드가 호출되면 서버는 `blocking`된다.

> blocking : 스레드가 대기 상태가 된다. (그래서 UI갱신, 이벤트 처리시에 호출하면 안된다.)

`accept() 메소드가 호출되면, 클라이언트와 통신할 Socket을 리턴한다.`

```java
try {
    Socket socket = serverSocket.accept();
} catch(Exception e) {}
```

> client의 port번호와 ip주소 얻기

```java
InetSocketAddress socketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();

String ip_address = socketAddress.getHostName();    // client ip address return
int port = socketAddress.getPort(); // client port number return
String address = socketAddress.toString;    // "IP:port"형태로 return
```

> 연결 종료

`serverSocket.close()`로 연결을 종료한다.