#### 버퍼의 생성

각 데이터 타입별로 `non-direct buffer`를 생성하기 위해서는 각 buffer 클래스의 `allocate()`와 `wrap()` 메소드를 호출하면 된다.

`direct buffer`는 ByteBuffer의 `allocateDirect()` 메소드를 호출하면 된다.

- allocate() 메소드

allocate 메소드는 JVM heap 메모리에 non-direct buffer를 생성한다.

```
ByteBuffer bytebuffer = ByteBuffer.allocate(int capacity);   // capacity개만큼의 byte 값을 저장
CharBuffer charBuffer = CharBuffer.allocate(int capacity);   // capacity개만큼의 char 값을 저장
IntBuffer intBuffer = IntBuffer.allocate(int capacity);     // capacity개만큼의 int 값을 저장
...
XXXBuffer field_name =  XXXBuffer.allocate(int capacity);
```

- wrap() 메소드

wrap() 메소드는 이미 생성되어 있는 자바 배열을 래핑해서 Buffer 객체를 생성한다.

```java
// 길이가 100인 byte[]를 이용해서 ByteBuffer 생성
byte[] byteArray = new byte[100];
ByteBuffer bytebuffer = ByteBuffer.wrap(byteArray);

// 길이가 100인 char[]를 이용해서 CharBuffer를 생성
char[] byteArray = new char[100];
CharBuffer charBuffer = CharBuffer.wrap(charBuffer);
```

또한 일부 데이터만 가지고 buffer객체를 생성할 수 있다.

```java
byte[] byteArray = new byte[100];
ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray, 0, 50);
```

또한 문자열으로도 CharBuffer를 생성할 수 있다.

```java
CharBuffer charBuffer = CharBuffer.wrap("Simple String");
```

- allocateDirect() 메소드

`allocateDirect()` 메소드는 운영체제가 관리하는 메모리에 `direct buffer`를 생성한다.

해당 메소드는 `ByteBuffer`에서만 제공한다.

각 타입별로 다이렉트 buffer를 생성하고 싶다면, ByteBuffer로 생성하고 난 후,

ByteBuffer의 `asCharBuffer()`, `asIntBuffer()` ... asXXXBuffer() 메소드를 이용해서 해당 타입별 direct buffer를 얻으면 된다.

```java
// 100개의 byte값 저장
ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);

// 50개의 char 값 저장
CharBuffer charBuffer = ByteBuffer.allocateDirect(100).asCharBuffer();

// 25개의 int값 저장
IntBuffer intBuffer = ByteBuffer.allocateDirect(100).asIntBuffer();
```

---

- byte 해석 순서 (ByteOrder)

운영체제에 따라 byte 해석 순서가 `LittleEndian`과 `BidEndian`으로 나윈다.

JVM은 무조건 `BigEndian`으로 동작하도록 되어 있다.

`Little Endian`으로 동작하는 운영체제에서 만든 데이터 파일을 `Big Endian` 으로 동작하는 운영체제에서 읽는다면

ByteOrder 클래스로 데이터 순서를 맞춰야 한다.

`Direct buffer`의 경우 운영체제의 기본 해석 순서로 `JVM의 해석 순서를 맞추는 것`이 성능에 도움이 된다.

다음과 같이 `order()` 메소드로 세팅해 주면 된다.

```java
ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100).order(ByteOrder.nativeOrder());
```