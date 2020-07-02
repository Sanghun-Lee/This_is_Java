#### 속성 바인딩

JavaFx는 다른 속성과 바인딩 될 수 있다.

두 개의 `TextArea` 컨트롤의 text 속성을 바인딩하면 `한쪽의 TextArea`에 내용을 입력했을 때

다른쪽 `TextArea`도 동일한 내용으로 자동 입력된다.

코드로는 다음과 같이 작성될 수 있다.

```java
TextArea textArea1 = new TextArea();
TextArea textArea2 = new TextArea();
textArea2.textProperty().bind(textArea1.textProperty());
```

그냥 `bind` 메소드는 `textArea1`에서 입력된 내용만 `textArea2`로 자동 입력되고,

반대로는 되지 않는다.

만약 양방향으로 바인딩 하고 싶다면 `bind()`메소드를 `bindBidirectional()` 메소드로 이용하거나

`Bindings.bindBidirectional()` 메소드를 이용하면 된다.

