#### HBox와 VBox 컨테이너

- HBox : `수평`으로 컨트롤을 배치하는 컨테이너이다.

- VBox : `수직`으로 컨트롤을 배치하는 컨테이너이다.

HBox와 VBox는 둘 다 크기를 자식에 맞게 재조정 하는데, HBox는 높이를, VBox는 폭을 확장한다.

크기 조정이 가능한 경우 자동으로 확장하는데,

`Button`의 경우 크기조절이 되지 않는데, 이는 `maxWidth`, `maxHeight`가 -1.0을 가지기 때문이다.

그래서 아래와 같이 값을 변경하면 크기조정이 가능하다.

```xml
<Button text="button">
    <maxWidth><Double fx:constant="MAX_VALUE" /></maxWidth>
    <maxHeight><Double fx:constant="MAX_VALUE" /></maxHeight>
</Button>
```

> HBox의 남은 폭을 채울 때

```xml
<HBox.hgrow>
    <Priority fx:constant="ALWAYS" />
</HBox.hgrow>
```

> VBox의 남은 높이를 채울 때

```xml
<VBox.vgrow>
    <Priority fx:constant="ALWAYS" />
</VBox.vgrow>
```