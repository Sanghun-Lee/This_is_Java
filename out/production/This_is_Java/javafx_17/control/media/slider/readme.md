#### slider와 ProgressBar, ProgressIndicator

기존에 `javafx_17.control.media`에 있는 파일에 slider만 추가한 것이다.

#### slider

선언 방법

```xml
<Slider prefHeight="높이" prefWidth="폭" showTickLable="true" showTickMarks="true" /> 
```

> ShowTickLabel : 0, 50, 100과 같은 수치를 보이도록 한다.
>
> ShowTickMarks : 눈금선을 보이도록 한다.

#### ProgressBar, ProgressIndicator

선언 방법

```xml
<ProgressBar prefHieght="15" prefWidth="100" progress="0.0" />
<ProgressIndicator prefHeight="47.0" prefWidth="31.0" pregress="0.0" />
```

`Bar`는 수평 모양의 컨트롤이고

`Indicator`는 원형 모양의 컨트롤이다.

Progress 속성값은 `0.0 ~ 1.0` 사이의 값을 가진다.

`setProgress` 메소드로 `progress` 값을 바꿀 수 있다.