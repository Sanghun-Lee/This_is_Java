##### System.in 필드

자바는 콘솔로 데이터를 입력받을 수 있도록 `System.in` 정적 필드를 제공한다.

`System.in`은 `InputStream` 타입의 필드이다.

그래서 다음과 같이 참조가 가능하다.

```java
InputStream inputStream = System.in;
```

터미널에서 데이터를 얻기 위해선 `InputStream`의 `read() 메소드`를 사용하면 된다.

`char inputChar = (char) inputStream.read();`

다만, InputStream은 `byte 단위`로 읽기 때문에, `숫자`와 `알파벳`은 잘 받지만,

`한글`을 받기 위해선 `read(byte[] b)` 메소드로 전체 입력 내용을 받고, 이를 이용해서 `String 객체`를 생성해서

한글로 변환해야 한다.

window에서 `Enter`키는 `캐리지 리턴(13) + 라인피드(10)` 을 더한 2byte이기 때문에

읽은 문자열을 String으로 변환하기 위해선 `읽은 바이트 수 - 2`로 대입해야 한다.

`String strData = new String(byteData, 0, readByteNo - 2);`