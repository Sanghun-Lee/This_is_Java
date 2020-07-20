#### 버퍼의 위치 속성

buffer의 4가지 위치 속성

- position
    - 현재 읽거나 쓰는 위치값.
    - 인덱스 값이라서 [0, limit]값의 범위를 갖는다.
   
- limit
    - 버퍼에서 읽거나 쓸 수 있는 위치의 한계값
    - [0, capacity]의 범위를 가진다.
    - 최초에 buffer를 만들었을 때는 `capacity`값을 가진다.
    
- capacity
    - 버퍼의 최대 데이터 개수를 나타낸다.
    
- mark
    - `reset()`메소드를 실행했을 때 돌아오는 위치를 지정하는 인덱스 값이다.
    - `mark()`메소드로 위치를 지정할 수 있다.
    - `position`이나 `limit`의 값이 `mark`보다 작을 경우 mark는 자동으로 제거된다.
    - mark가 없는 상태에서 reset() 메소드를 호출하면 `InvalidMarkException`이 발생한다.
    
즉 4가지 속성의 크기를 다음과 같다.

```
0 <= mark <= position <= limit <= capacity
```

---

#### Buffer 메소드

##### 데이터를 읽고 저장하는 메소드

- buffer에 데이터를 저장하는 메소드 : `put()`
- buffer에 데이터를 읽는 메소드 : `get()`

`put()`, `get()` 모두 데이터를 `상대적` 또는 `절대적`으로 데이터를 읽고 쓸 수 있다.

상대적의 경우 `position`을 기준으로 데이터를 읽고 쓴다.

`position`이 `limit`에 도달했는데도 put, get을 사용하면

get -> `BufferUnderflowException` / put -> `BufferOverflowException`이 발생한다.

사용 예시

```java
// Buffer 생성
ByteBuffer byteBuffer = ByteBuffer.allocateDirect(10);

// 상대적 데이터 저장
byteBuffer.put((byte)10);

// 절대적 위치에 데이터 저장
byteBuffer.put(2, (byte)12);

// 데이터를 읽기 전에 flip 메소드로 position 위치를 바로잡아야 한다.
byteBuffer.filp();

// 상대적 데이터 읽기
byte data = byteBuffer.get();

// 절대적 데이터 읽기
byte data = byteBuffer.get(2);
```

##### compact 메소드

예제파일 : `CompactExample.java`

`compact`메소드는 position에서 limit사이에 저장된 값은 0번부터 시작해서 덮어쓰고,

position은 그 뒷부분을 가리키게 된다.

limit는 capacity값을 지칭한다.