### 뷰 컨트롤

뷰 컨트롤은 텍스트 또는 이미지를 보여주는데,

- 목록 형태로 보여주는 `ListView`

- 테이블 형태로 보여주는 `TableView`

- 이미지를 보여주는 `ImageView`

가 있다.

> ImageView

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

> ListView 컨트롤

ListView는 항목들을 목록으로 보여주는 컨트롤이다.

선언방법은 다음과 같다.

`<ListView prefWidth="폭" prefHeight="높이" />`

ListView에 항목을 추가하려면 `setItems(ObservableList<T> value)` 메소드를 사용한다.

`ObservableList`의 구현 객체는 `FXCollections.observableArrayList(E ... items)` 정적 메소드로 생성하면 된다.

`listView.setItems(FXCollections.observableArrayList("Swing", "JavaFx"));`

ListView가 `고정 항목` 일 때는 FXML 파일에서 다음과 같이 선언할 수 있다.

```xml
<ListView fx:id="listView" prefHeight="100" prefWidth="100">
    <items>
        <FXCollections fx:factory="boservableArrayList">
            <String fx:value="Swing" />
            <String fx:value="JavaFx" />
        </FXCollections>
    </items>
</ListView>
``` 

속성 감시

ListView에서 선택된 인덱스와 메소드를 얻으려면 `속성 감지`를 이용할 수 있다.

---

> TableView

TableView를 FXML로 선언하는 방법은 `<columns>` 태그 안에 만들고자 하는 컬럼의 수 만큼

`<TableColumn>` 태그를 선언하면 된다.

```xml
<TableView prefHeight="100" prefWidth="300">
    <columns>
        <TableColumn prefWidth="150" text="스마트폰" />
        <TableColumn prefWidth="150" text="이미지" />
    </columns>
</TableView>
```