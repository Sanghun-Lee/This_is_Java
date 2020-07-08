### TCP 네트워킹

TCP는 연결지향 통신이고, 데이터를 정확하고, 안전하고, 순서대로 전달한다.

Java는 TCP 네트워킹을 위해

`java.net.ServerSocekt`과 `java.net.Socket`클래스를 재공한다.

지금부터 살펴보도록 하자.

#### ServerSocket과 Socket의 용도

TCP의 역할은 두가지 이다.

1. client가 연결 요청을 하면 연결을 수락하는 것

2. 연결된 클라이언트와 통신하는 것

이 때 client의 연결 요청을 기다리면서 연결 수락을 담당하는 것이 `java.net.ServerSocket`이다.

이는 `Server`입장에서 사용한다.

연결된 client와 통신을 담당하는 것은 `java.net.Socket`이다.

이는 `Client`입장에서 사용한다.

client가 연결 요청을 하면, ServerSocket에서 연결을 수락하고, Socket을 생성해서 통신한다.

> 포트

서버는 `port 번호`를 가져야 하고, 이 포트는 `ip주소와 바인딩` 해서 사용한다.

client가 연결 요청을 하면 `accept()`메소드로 연결 수락을 한다.