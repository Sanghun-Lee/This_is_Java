#### JavaFx 메뉴바와 툴바

##### MenuBar 컨트롤

`MenuBar`란, 프로그램 상단에 "`파일", "편집" ..` 과 같은 메뉴가 MenuBar에 해당한다.

Menu는 아이템으로 아래와 같은 메뉴를 추가할 수 있다.

- MenuItem
- CheckMenuItem : 클릭하면 선택, 다시 클릭하면 미선택
- RadioMenuItem : 같은 그룹 중에서 하나만 선택
- CustomMenuItem
- SeparatorMenuItem : 가로 구분선

을 추가할 수 있다.

또한 `"새로 만들기", "열기", "저장"` 과 같은 서브메뉴도 추가할 수 있다.

예시 xml

```xml
<Menu text="파일">
    <items>
        <MenuItem text="새로 만들기" onAction="#handleNew">
            <accelerator>
                <KeyCodeCombination alt="DOWN" code="N" control="UP" meta="UP" shift="DOWN" shortcut="UP" />
            </accelerator>
            <graphic>
                <ImageView><image><Image url="@icons/new.png" /></image></ImageView>
            </graphic>
        </MenuItem>
    </items>
</Menu>
```

accelerator : 단축키 설정, `DOWN`으로 설정된 키와 `code`키를 동시에 누르면 `onAction`이 실행된다.

graphic : 앞에 아이콘을 추가한다.

---

##### ToolBar 컨트롤

빠르게 작업하고 싶다면 `ToolBar`컨트롤을 추가하는것이 좋다.

toolBar는 저장버튼, 불러오기버튼과 같은 버튼들이 있는 하나의 바 이다.

xml 예시

```xml
<ToolBar>
    <items>
        <Button onAction="#handleNew">
            <graphic>
                <ImageView><image><Image url="@icons/new.png" /></image></ImageView>
            </graphic>
        </Button>
    </items>
</ToolBar>
```