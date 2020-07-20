#### 버퍼의 종류

buffer는 저장되는 데이터 타입에 따라 분류될 수 있고,

`JVM`을 사용하는 `non-direct`와 시스템 `Memory`를 사용하는 `Direct`로 분류된다.

- 데이터 타입에 따른 버퍼

데이터 타입에 따라 별도의 클래스를 제공한다.

해당 버퍼들은 `Buffer`추상 클래스를 모두 상속하고 있다.

`Buffer`, `ByteBuffer`, `CharBuffer`, `ShortBuffer`, `IntBuffer`, ....

`MappedByteBuffer` : ByteBuffer의 하위 클래스로 `Random Access`를 위해 파일의 내용을 메모리에 매핑시킨 버퍼이다.

-  non-direct buffer, direct buffer

| 구분 | non-direct buffer | direct buffer |
| --- | --- | --- |
| 사용하는 메모리 공간 | JVM의 heap 메모리 | 운영체제의 메모리 |
| 버퍼 생성 시간 | 버퍼 생성이 빠르다 | 버퍼 생성이 느리다 |
| 버퍼의 크기 | 작다 | 크다 |
| 입출력 성능 | 낮다 | 높다 |

`Direct Buffer`는 `native C함수`를 호출해야 해서 생성에 느리다.

`non direct buffer`는 입출력시에 `임시 다이렉트 buffer`를 생성해서 운영체제의 `native I/O`를 수행해서 입출력 성능에 느리다.

> Buffer의 생성

```java
Direct Buffer : ByteBuffer.allocateDirect(int capacity);

non-direct Buffer : ByteBuffer.allocate(int capacity);
```