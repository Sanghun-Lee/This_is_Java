#### 성능 향상 보조 스트림

파일 입출력에는 HDD가 느리기 때문에 속도가 느려진다.

그래서 프로그램이 입출력 소스와 직접 작업하지 않고 중간에 `메모리 버퍼(buffer)`와 작업함으로써

실행 성능을 향상시킬 수 있다.

그래서 보조 스트림 중에는 이와 같이 `메모리 버퍼를 제공`하여 프로그램의 실행 성능을 향상시키는 것들이 있다.

- BufferedInputStream
- BufferedReader
- BufferedOutputStream
- BufferedWriter

---

##### BufferedInputStream, BufferedReader

`BufferedInputStream`은 <strong>바이트 입력 스트림에 연결되어 버퍼를 제공</strong>해주는 보조 스트림이고,

`BufferedReader`는 <strong>문자 입력 스트림에 연결되어 버퍼를 제공</strong>해주는 보조 스트림이다.

> 사용 방법

```java
BufferedInputStream bis = new BufferedInputStream(바이트 입력 스트림);
BufferedReader br = new BufferedReader(문자 입력 스트림);
```

위와같이 보조 스트림을 연결하면 8192 내부 버퍼 사이즈를 가지게 된다.

---

##### BufferedOutputStream, BufferedWriter

`BufferedOutputStream`은 <strong>바이트 출력 스트림에 연결되어 버퍼를 제공</strong>해주는 보조 스트림이고,

`BufferedWriter`는 <strong>문자 출력 스트림에 연결되어 버퍼를 제공</strong>해주는 보조 스트림이다.

> 사용 방법

```java
BufferedOutputStream bos = new BufferedOutputStream(바이트 출력 스트림);
BufferedWriter bw = new BufferedWriter(문자 출력 스트림);
```

마지막 출력 작업을 마친 후에는 `flush()`메소드를 호출해서 잔류하고 있는 데이터를 모두 보내도록 해야 한다.