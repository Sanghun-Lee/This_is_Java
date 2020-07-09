#### UDP 네트워킹

`UDP`는 비연결 지향적 통신이다.

데이터를 주고받을 때 연결 절차를 거치지 않기 때문에, TCP보다 빠른 전송을 할 수 있다.

다만 신뢰성이 떨어진다는 단점이 있다.

Java는 UDP 프로그래밍을 위해

`java.net.DatagramSocket`과 `java.net.DatagramPacket`클래스를 제공한다.

- `java.net.DatagramSocket` : 발신점과 수신점에 해당하는 클래스

- `java.net.DatagramPacket` : 주고받는 패킷 클래스

##### 발신자 구현

먼저 `DatagramSocket`을 생성해야 한다.

`DatagramSocket datagramSocket = new DatagramSocket();`

보내고자 하는 데이터 `byte[]` 배열로 생성

`byte[] byteArr = data.getBytes("UTF-8");`

수신자 정보를 담을 `DatagramPacket`을 생성한다.

```
DatagramPacket packet = new DatagramPacket(
        보낼 데이터, 데이터 길이, new InetSocketAddress(ip주소, port)
        );
```

데이터 전송

`datagramSocket.send(packet);`

더 보낼 데이터가 없는경우 `.close()`로 닫아준다.

`datagramSocket.close();`

##### 수신자 구현

DatagramSocket 생성

`DatagramSocket datagramSocket = new DatagramSocket(port);`

`receive()` 메소드로 패킷 읽을 준비를 한다.

receive() 메소드를 호출하면 `blocking` 된다.

```java
// 매개변수 : 패킷을 저장할 바이트 변수, 최대 읽을 수 있는 바이트 길이
DatagramPacket packet = new DatagramPacket(new byte[100], 100);
datagramSocket.receive(packet);
```

얻은 데이터 문자열로 변환

`String data = new String(packet.getData(), 0, packet.length, "UTF-8");`

응답 패킷을 보내고 싶다면 발신자의 `IP`와 `port`를 알아야 하는데,

`DatagramPacket`의 `getSocketAddress()`를 호출하면 된다.

`SocketAddress socketAddress = packet.getSocketAddress();`

통신이 끝나면 `close()`메소드를 호출한다.

`datagramSocket.close();`