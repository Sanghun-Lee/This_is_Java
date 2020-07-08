#### 프린터 보조 스트림

`PrintStream`과 `PrintWriter`는 프린터와 유사하게 출력하는 `print()`, `println()` 메소드를 가지고있는 보조 스트림이다.

`PrintStream`은 바이트 출력 스트림과 연결되고,

`PrintWriter`는 문자 출력 스트림과 연결된다.

> 사용법

```java
PrintStream ps = new PrintStream(바이트 출력 스트림);
PrintWriter pw = new PrintWriter(문자 출력 스트림);
```

##### printf()

PrintStream과 PrintWriter는 `printf()`도 제공한다.

`printf()` 메소드는 형식화된 문자열을 출력할 수 있도록 해준다.

형식화된 문자열은 C언어의 `printf 함수` 와 동일하다.

`%d : 정수, %s : 문자열...`