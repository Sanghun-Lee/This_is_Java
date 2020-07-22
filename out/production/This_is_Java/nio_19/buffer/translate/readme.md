#### Buffer 변환

채널이 데이터를 읽고 쓰는 버퍼는 모두 `ByteBuffer`이다.

그래서 채널을 통해 읽은 데이터를 char, int, double과 같은 다른 타입으로 변환하려면

다른 타입 버퍼로 변환해야 한다.

##### ByteBuffer <-> String

문자열을 파일이나 네트워크로 전송하려면 특정 문자셋으로 인코딩 해야한다.

문자셋으로 인코딩 하기 위해선 먼저 `java.nio.charset.Charset`객체가 필요한다.

```java
Charset charset = Charset.forName("UTF-8");     // 매개값으로 주어진 문자셋
// or
Charset charset = Charset.defaultCharset();     // 운영체제가 사용하는 디폴트 문자셋
```

- 문자셋 인코딩 후 데이터 보내기

```java
String data = "...";
ByteBuffer byteBuffer = charset.encode(data);
```

- 특정 문자셋으로 온 데이터를 읽기

```java
ByteBuffer byteBuffer = ...;
String data = charset.decode(byteBuffer).toString();
```

##### ByteBuffer <-> IntBuffer

int 배열의 값을 파일이나 네트워크로 출력하기 위해선 `int[]` 배열 또는 `IntBuffer`로 부터 `ByteBuffer`를 생성해야 한다.

ByteBuffer 생성 시 int[] 배열 또는 IntBuffer로 부터 `4배 큰 capacity`를 가진 `ByteBuffer`를 생성해야 한다.

```java
int[] data = { 10, 20 };
IntBuffer intBuffer = IntBuffer.wrap(data);
ByteBuffer byteBuffer = ByteBuffer.allocate((intBuffer.capacity) * 4);
for(int i = 0; i < intBuffer.capacity(); i++) {
    byteBuffer.putInt(intBuffer.get(i));
}
byteBuffer.flip();
```

- 배열 복원

```java
// 데이터를 받을 ByteBuffer 생성
ByteBuffer byteBuffer = "...";

// ByteBuffer를 intBuffer로 변환
IntBuffer intBuffer = byteBuffer.asIntBuffer();
int[] data = new int[intBuffer.capacity()];
intBuffer.get(data);    // intBuffer로 데이터를 받음
```