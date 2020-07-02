#### FXML 컨트롤러

프로그램적 레이아웃 말고, FXML 레이아웃으로 파일당 별도 `컨트롤러`를 지정해서

이벤트를 처리할 수 있기 때문에 FXML 레이아웃과 이벤트 처리 코드를 완전히 분리할 수 있다.

먼저 FXML파일에서 `fx:controller`값을 이벤트를 처리할 package로 값을 대입해야 한다.

```xml
<root xmlns="http://javafx.com/fxml" fx:controller="packageName.ControllerName" >
    <!-- ...  -->
</root>
```

컨트롤러 (해당 자바 클래스 파일)은 `Initializable`인터페이스를 구현한 클래스로 작성하면 된다.

```java
public class ControllerName implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) { }
}
```

---

##### fx:id 속정과 @FXML 컨트롤 주입

이벤트 처리시에 UI변경을 위해 컨테이너 및 컨트롤을 참조할 필요가 있다.

이를 위해서 FXML의 컨트롤들은 `fx:id`속성을 가질 필요가 있다.

```xml
<!-- .... -->
<children>
    <Button fx:id="button1" text="버튼1" />
    <Button fx:id="button2" text="버튼2" />
    <Button fx:id="button3" text="버튼3" />
</children>
```

클래스파일에서 참조하기 - `@FXML` 어노테이션을 적용하고, `fx:id` 속성명과 필드명이 동일해야 한다.

```java
public class ControllerName implements Initializable {
    @FXML private Button button1;
    @FXML private Button button2;
    @FXML private Button button3;
    // ...
}
```

---

##### 이벤트 처리 메소드 매핑

컨트롤러에서 `EventHandler`를 생성하지 않고도 바로 이벤트 처리 메소드를 연결해 보자.

fxml 파일에서 Button 객체를 만들 때 `onAction`을 속성값으로 `#메소드명`을 주면

내부적으로 `EventHandler` 객체가 생성되어서 컨트롤러(java 클래스 파일)에 해당 메소드만 작성하면 된다.

FXML : `<Button fx:id="button" text="버튼" onAction="#handleButtonAction" />`

Java : `public void handleButtonAction(ActionEvent event) { ... }`