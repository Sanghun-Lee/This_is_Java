### 뷰 컨트롤

뷰 컨트롤은 텍스트 또는 이미지를 보여주는데,

- 목록 형태로 보여주는 `ListView`

- 테이블 형태로 보여주는 `TableView`

- 이미지를 보여주는 `ImageView`

가 있다.

##### ImageView

ImageView는 이미지를 보여주는 컨트롤이다.

선언방법은 다음과 같다.

`<ImageView fitWidth="폭" fitHeight="높이" preserveRatio="true" />`

`fitWidth`와 `fitHeight` : ImageView의 `폭`과 `높이`

`preserveRatio` : 이미지의 종횡비를 유지할 지 여부

ImageView에 보여줄 이미지는 두 가지 방법으로 설정할 수 있다.

- ImageView의 생성자 매개값으로 `Image`객체를 설정하는 것

```xml
<ImageView preserveRatio="true">
    <Image url="@images/flower.png" />
</ImageView>
```

두 번째 방법은 ImageView의 `setImage()` 메소드로 설정하는 방법이다.

```xml
<ImageView fitWidth="200" fitHeight="150" preserveRatio="true">
    <image>
        <Image url="@images/flower.png" />
    </image>
</ImageView>
```

> url로는 상대경로로 "@이미지 경로"를 값으로 주면 된다.

---

##### ListView 컨트롤

ListView는 항목들을 목록으로 보여주는 컨트롤이다.

> 선언 방법

`<ListView prefWidth="폭" prefHeight="높이" />`

> 항목 추가하기

항목을 추가하는 방법은 두 가지가 있다.

- Java파일에서 추가 -> `setItems` 메소드를 사용한다.

-  FXML에서 추가 (선언과 동시에 초기화)

Java파일에서 ListView에 항목을 추가하려면 `setItems(ObservableList<T> value)` 메소드를 사용한다.

`ObservableList`의 구현 객체는 `FXCollections.observableArrayList(E ... items)` 정적 메소드로 생성하면 된다.

`listView.setItems(FXCollections.observableArrayList("Swing", "JavaFx"));`

ListView가 `고정 항목` 일 때는 FXML 파일에서 다음과 같이 선언할 수 있다.

```xml
<ListView fx:id="listView" prefHeight="100" prefWidth="100">
    <items>
        <FXCollections fx:factory="observableArrayList">
            <String fx:value="Swing" />
            <String fx:value="JavaFx" />
        </FXCollections>
    </items>
</ListView>
``` 

> 인덱스 항목 얻기

인덱스 항목은 속성 감시로 얻을 수 있다.

- `SelectedIndexProperty` : 선택된 인덱스를 받음
- `SelectedItemProperty` : 선택된 항목을 받음

예시

```java
listView.getSelectionModel().selectedItemProperty().addListener(
    new ChangeListener<String> () {
        @Override
        public void changed(.... String oldValue, String newValue) { }
    }
)
```

---

##### TableView

TableView : 텍스트, 이미지를 table(표) 형태로 보여주는 뷰 컨트롤

`<columns>` 태그 안에 만들고자 하는 컬럼 수 만큼 `<TableColumn>` 태그를 선언한다.

```xml
<TableView prefHeight="100" prefWidth="300">
    <columns>
        <TableColumn prefWidth="150" text="스마트폰" />
        <TableColumn prefWidth="150" text="이미지" />
    </columns>
</TableView>
```

> table row에 항목 추가

먼저 항목을 추가하기 위해선 항목에 추가될 Model 객체가 필요하다. (예제파일에선 `Phone.java`)

Model Class의 필드 타입은 `SimpleXXXProperty`를 사용하면 된다.

> table row에 model 속성 연결

Model 클래스를 만들었을 경우 `model 속성`과 `TableColumn`을 연결시키는 코드를 작성해야 한다.

- Model Class의 어떤 값이 어느 column에 들어가는지 설정해 주어야 한다.

코드를 작성하면 아래와 같다.

```java
TableColumn tcSmartPhone = tableView.getColumns().get(0);   // 0번째 Column을 얻는다.
tcSmartPhone.setCellValueFactory(new PropertyValue("smartPhone"));
// 0번째 column의 속성 값에 smartPhone 필드값이 오도록 만든다.
```

> style

style이 필요한 경우 `tcSmartPhone`의 `setStyle`메소드를 호출하면 된다.

##### tableView 데이터 설정

`setItems` 메소드를 이용한다.

매개값으로는 `observableList`를 매개값으로 전달한다.

```java
ObservableList phoneList = FXCollections.observableArrayList(
    new Phone("갤럭시S1", "phone01.png"),
    new Phone("갤럭시S2", "phone02.png")
);

tableView.setItems(phoneList);
```

##### tableView의 행의 인덱스와 모델 객체 얻기

속성 감시를 이용해서 얻을 수 있다.

`SelectedItemProperty`메소드와 해당 `Listener`를 이용해서 선택된 행의 인덱스 또는 값을 얻을 수 있다.

```java
tableView.getSelectionModel().selectedItemProperty().addListener(
    new ChangeListener<Phone> () {
    @Override
    public void changed(.... Phone oldValue, Phone newValue) { }
    }
);
```