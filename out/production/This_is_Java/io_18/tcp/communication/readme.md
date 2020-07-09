#### Socket 데이터 통신

client가 연결 요청(`connect()`)을 하고, server가 수락(`accept()`)를 했다면,

양쪽의 socket 객체로 부터 `입력 스트림(InputStream)`과 `출력 스트림(OutputStream)`을 얻을 수 있다.

아래 코드는 Socket에서 InputStream와 OutputStream을 얻는 코드이다.

```java
// 입력 스트림 얻기
InputStream is = socket.getInputStream();

// 출력 스트림 얻기
OutputStream os = socket.getOutputStream();
```

> 데이터 전송

데이터 전송은 보낼 데이터를 `byte[]` 배열로 생성하고, 이를 매개값으로

`OutputStream`의 `write()`메소드를 호출하면 된다.

```java
String data = "보낼 데이터";
byte[] byteArr = data.getBytes("UTF-8");    // 문자열 인코딩 타입 대입

OutputStream outputStream = socket.getOutputStream();   // outputStream 얻기
outputStream.write(byteArr);
outputStream.flush();
```

> 데이터 받기

보낸 데이터를 받기 위해선 `byte[]` 배열을 생성하고

`InputStream`의 `read()` 메소드를 이용하면 된다.

```java
byte[] byteArr = new byte[100];

InputStream inputStream = socket.getInputStream();
int readByteCount = inputStream.read(byteArr);

String data = new String(byteArr, 0, readByteCount, "UTF-8");
```