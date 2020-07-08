#### 보조 스트림

보조 스트림이란, 다른 스트림과 연결되어 여러 가지 편리한 기능을 제공해주는 스트림을 말한다.

보조 스트림은 자체적으로 입출력 할 수 없기 때문에

`InputStream`, `OutputStream`, `Reader`, `Writer` 등에 연결해서 입출력을 수행한다.

> 보조 스트림의 생성

`보조스트림 변수이름 = new 보조스트림(연결스트림);`

보조 스트림은 또 다른 보조 스트림과 연결되어 스트림 체인을 구성할 수 있다.

| 패키지 | 설명 | 보조스트림 이름 |
| --- | --- | --- |
| to_char | 문자 변환 보조 스트림 | InputStreamReader ,OutputStreamWriter |
| buffered | 성능 샹항 보조 스트림 | BufferedInputStream, BufferedOutputStream |
| primitive | 기본 타입 입출력 보조 스트림 | DataInputStream |
| printer | 프린터 보조 스트림 | PrintStream, PrintWriter |
| object | 객체 입출력 보조 스트림 | ObjectInputStream, ObjectOutputStream | 