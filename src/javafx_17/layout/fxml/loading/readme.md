#### FXML 로딩

FXML을 작성했다면, 이를 Java 파일에서 읽어드려 선언된 내용을 객체화 해야 한다.

이를 `FXML 로딩`이라고 한다.

FXML 파일을 로딩하기 위해서는 `javafx.fxml.FXMLLoader`를 사용해야 한다.

로딩하는 방법은 `정적 메소드`와 `인스턴스 메소드`를 사용하는 방법이 있다.

> 정적 메소드 사용

```
Parent root = FXMLLoader.load(getClass().getResource("xxx.fxml"));
```

> 인스턴스 메소드 사용

```java
FXMLLoader loader = new FXMLLoader(getClass().getResource("xxx.fxml"));
Parent root = (Parent) loader.load();
```

그리고 최종적으론 이 `root`를 장면(Scene)객체를 생성하면 된다.

`Scene scene = new Scene(root);`