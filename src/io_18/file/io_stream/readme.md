#### FileInputStream, FileOutputStream

##### FileInputStream

FileInputStream 클래스는 파일로부터 `바이트 단위`로 데이터를 읽을때 사용하는 클래스이다.

바이트 단위로 읽기 때문에 `그림`, `오디오`, `비디오` 등 모든 종류의 파일을 읽을 수 있다. 

> FileInputStream을 생성하는 방법

```java
// 첫 번째 방법
FileInputStream fis = new FileInputStream("Path");

// 두 번째 방법
File file = new File("Path");
FileInputStream fis = new FileInputStream(file);
```

`FileInputStream`은 객체가 생성될 때 `파일을 직접 연결`하기 때문에, 파일이 없으면 `FileNotFoundException`이 발상하기 때문에

`try - catch`문으로 예외 처리를 해야한다.

---

##### FileOutputStream

FileOutputStream 클래스는 파일로부터 `바이트 단위로` 데이터를 쓸 수 있다(저장할 수 있다).

바이트 단위로 저장하기 때문에 `그림`, `오디오`, `비디오` 등 모든 종류의 데이터를 저장할 수 있다.

> FileOutputStream을 생성하는 방법

```java
// 첫 번째 방법
FileOutputStream fos = new FileOutputStream("Path");

// 두 번째 방법
File file = new File("Path");
FileOutputStream fos = new FileOutputStream(file);
```

주의할 점은 `파일이 이미 존재할 경우`, 데이터를 출력하면 `파일을 덮어쓰게 된다`.

그래서 파일 내용 끝에 데이터를 추가하는 경우 생성자의 `두번째 매개값을 true로` 주면 된다.

```java
FileOutputStream fos = new FileOutputStream("Path", true);
FileOutputStream fos = new FileOutputStream(file, true);
```

