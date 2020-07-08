#### 문자열 변환 보조 스트림

##### InputStreamReader

소스 스트림이 `바이트 기반 스트림` (InputStream, OutputStream, FileInputStream....)이면서

입출력 데이터가 `문자`라면 `InputStreamReader`, `OutputStreamWriter를` 이용해서 문자 기반 스트림으로 변환할 수 있다.

> InputStreamReader

바이트 입력 스트림(InputStream, FileInputStream...)을 문자 입력 스트림은 `Reader`로 변환시킨다.

`Reader reader = new InputStreamReader(바이트 입력 스트림);`

예시

```java
InputStream is = System.in;
Reader reader = new InputStreamReader(is);
```

---

##### OutputStreamWriter

OutputStreamWriter는 바이트 출력 스트림에 연결되어 문자 출력 스트림인 `Writer로 변환`시키는 보조 스트림이다.

`Writer writer = new OutputStreamWriter(바이트출력스트림);`

예시

```java
FileOutputStream fos = new FileOutputStrea("Path");
Writer writer = new OutputStreamWriter(fos);
```