#### FXML 레이아웃

FXML은 XML기반의 마크업 언어이다.

FXML은 태그로 이루어져 있어서, 태그에 익숙한 디자이너와 협업이 가능하다.

또한 간단한 레이아웃 수정 또는 스타일 변경 시 자바 코드를 새로 컴파일 할 필요가 없다.

---

##### FXML 작성규칙

> FXML로 선언된 태그는 자바 코드로 변환되어 실행되기 때문에, 자바 코드와 매핑 관계가 존재한다.

- 패키지 선언

자바코드의 패키지 선언은 `<?import?>` FXML 태그와 매칭된다.

| 자바 코드 | FXML 태그 |
| --- | --- |
| import javafx.scene.layout.HBox; | \<?import javafx.scene.layout.HBox?>
| import javafx.scene.control.*; | \<?import javafx.scene.control.*?>

- 태그 선언

FXML 태그는 `< >` 사이에 태그 이름을 작성한 것이다.

시작 태그가 있으면 끝 태그도 있다.

`<태그이름> .... </태그이름>`

태그 내용이 없을 경우 다음과 같이 작성한다. `<태그 이름 />`

- 속성 선언

속성값은 `"` 또는 `'`로 반드시 감싸주어야 한다.

`<태그이름 속성명="값" 속성명='값'> ... </태그이름>`

자바 코드

```java
Button button = new Button();
button.setText("확인");
```

FXML (Setter 태그)

```xml
<Button>
    <text>확인</text>
</Button>
```

FXML (Setter 속성)

```xml
<Button text="확인" />
```

- 객체 선언

기본적으로 다음과 같이 `<클래스명>`으로 태그를 작성하면 `new 연산자로 기본 생성자를 호출`해서 객체를 생성한다.

매개변수가 있는 생성자를 호출할 때에는 매개변수에 `@NamedArg` 어노테이션이 있으면 속성명이나 자식 태그로 작성할 수 있다.

대표적인 예시가 `Insets` 클래스 이다.

> 자바 코드

```java
hBox.setPadding(new Insets(10, 10, 10, 10));
```

> FXML

```xml
<HBox>
    <padding>
        <Insets top="10" right="10" bottom="10" left="10" />
    </padding>
</HBox>
```

> Insets 생성자

```java
public Insets(@NamedArg("top") double var1, @NamedArg("right") double var3, @NamedArg("bottom") double var5, @NamedArg("left") double var7)
```

- \<클래스 fx:value="값" />

`valueOf(String)` 메소드를 제공해서 객체를 생성하는 경우 다음과 같이 FXML 태그를 작성할 수 있다.

`<클래스 fx:value="값" />`

예시

Java : `Integer.valueOf("1");` / FXML : `<Integer fx:value="1" />`

- \<클래스 fx:constant="상수" />

클래스에 정의된 상수를 얻고 싶을 경우 다음과 같이 작성한다.

`<클래스 fx:constant="상수" />`

예시

Java : `button.setMaxWidth(Double.MAX_VALUE);`

FXML : `<Button><maxWidth><Double fx:constant="MAX_VALUE" /></maxWidth></Button>`

- \<클래스 fx:factory="정적메소드">

정적 메소드로 객체를 얻어야 하는 경우 다음과 같이 FXML을 작성한다.

`<클래스 fx:factory="정적메소드">`

예시

Java : `combo.setItems(FXCollections.observableArrayList(...));`

FXML : `...<FXCollections fx:factory="observableArrayList">`