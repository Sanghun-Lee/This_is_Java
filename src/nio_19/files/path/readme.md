#### 경로 (Path)

NIO에서 파일의 경로를 지정할 때에는 `Path`클래스를 사용한다.

Path의 구현 객체를 얻기 위해선 `Paths.get(...)` 메소드를 호출하면 된다.

```java
Path path = Paths.get(String first, String ... more);
Path path = Paths.get(URI uri);
```

예시

```java
Path path = Paths.get("/home/hun/test.txt");
Path path = Paths.get("home", "hun", "test.txt");
// 상대경로
Path path = Paths.get("../readme.md");
```