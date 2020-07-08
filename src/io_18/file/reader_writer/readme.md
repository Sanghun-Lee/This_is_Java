#### FileReader, FileWriter

FileReader 클래스는 텍스트 파일을 읽어들일 때 사용하는 `문자 기반 스트림`이다.

> FileReader 객체 생성 방법

```java
// 방법 1
FileReader fd = new FileReader("Path");

// 방법 2
File file = new File("Path");
FileReader fr = new FileReader(file);
```

파일이 존재하지 않으면 `FileNotFoundException`이 발생하기 때문에, `try-catch`문으로 예외 처리를 해야 한다.

FileReader는 사용방법이 `Reader`와 동일하기 때문에, `read()메소드` 또는 `read(char[] buf) 메소드`를 이용하면 된다.

---

##### FileWriter

FileWriter 클래스는 텍스트 파일을 저장할 때 사용하는 문자 기반 스트림이다.

> FileWriter 객체 생성 방법

```java
// 방법 1
FileWriter fw = new FileWriter("Path");

// 방법 2
File file = new File("Path");
FileWriter fw = new FileWriter(file);
```

FileWriter를 생성하면 지정된 파일이 이미 존재한 경우 해당 파일을 덮어쓰게 된다.

기존의 파일 내용 끝에 데이터를 추가할 경우 `FileWriter` 생성자 `두 번째 매개값을 true`를 주면 된다.

```java
FileWriter fw = new FileWriter("Path", true);
FileWriter fw = new FileWriter(file, true);
```

`FileWriter`는 `Writer`의 하위 클래스 이기 때문에 Writer에 있는 `write()`, `write(String str)`등을

그대로 사용하면 된다.