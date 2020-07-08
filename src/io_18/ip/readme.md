### 네트워크

#### 서버와 클라이언트

> 서버

서버는 클라이언트에서 오는 요청을 처리해주고, 응답을 클라이언트한테 보낸다.

> 클라이언트

클라이언트는 서버에게 요청을 보내고 응답을 받는다.

#### InetAddress로 IP주소 얻기

> 로컬 컴퓨터의 IP주소 얻기

```java
InetAddress ia = InetAddress.getLocalHost();
```

외부 컴퓨터의 도메인 이름을 알고있으면 해당 메소드로 InetAddress 객체를 얻을 수 있다.

```java
InetAddress ia = InetAddress.getByName(String host);
InetAddress[] iaArr = InetAddress.getAllByName(String host);
```

