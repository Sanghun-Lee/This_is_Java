#### 파일 채널

`java.nio.channels.FileChannel`을 이용하면 파일 읽기와 파일 쓰기를 할 수 있다.

`FileChannel`은 동기화 처리가 되어있어서 멀티 스레드 환경에서 사용해도 안전하다.

##### FileChannel 생성 및 닫기

FileChannel은 정적 메소드인 `open()`으로 얻을 수 있고,

`IO`의 `FileInputStream`, `FileOutputStream`의 `getChannel` 메소드를 호출해서 얻을 수 있다.

open 메소드로 FileChannel을 얻는 방법

```java
FileChannel fileChannel = FileChannel.open(Path path, OpenOption... options);
``` 

options 매개값은 다음과 같은 열거 상수를 사용하면 된다.

`READ, WRITE, CREATE, CREATE_NEW, APPEND....`

예시

```java
FileChannel fileChannel = FileChannel.open(
    Path.get("path..."),
    StandardOpenOption.CREATE_NEW,
    StandardOpenOption.WRITE
);
```

`fileChannel.close()` 메소드로 리소스를 닫을 수 있다.