#### JavaFx CSS 스타일

JavaFx도 `CSS`를 이용해서 스타일을 바꿀 수 있다.

CSS 스타일을 `W3C CSS`에 정의되어 있고, JavaFx에서는 W3C CSS에 `-fx-`만 붙이면 된다.

##### CSS를 JavaFx에 적용하는 방법

> 인라인(inline) 스타일

다음과 같이 태그 내부에 CSS 스타일을 작성할 수 있다.

```xml
<컨테이너 style="속성:값; 속성:값; ..." />
<컨트롤 style="속성:값; 속성:값; ... " />
```

> 외부 CSS 파일

인라인 방식으로 스타일을 작성하면 fxml 파일과 코드가 같이 있기도 하고, 중복 스타일 시에 중복 코드가 늘어난다는 단점이 있다.

그래서 코드 재사용성을 줄이기 위해서 `외부 CSS 파일을 작성`해서 적용하는것이 일반적이다.

- 선택자

스타일을 적용할 컨테니어와 컨트롤을 선택해주는 `선택자`가 있다.

```css
선택자 {
    속성:값; 속성:값; ...
}
```

선택자에는 3가지 종류의 선택자가 있다.

| 선택자 | 작성 방법 |
| --- | --- |
| Type 선택자 | Type { 속성:값; 속성:값; ... } |
| id 선택자 | #id { 속성:값; 속성:값; ... } |
| class 선택자 | .class { 속성:값; 속성:값; ... } |

- Type 선택자

type 선택자는 같은 타입의 컨테이너, 컨트롤을 모수 선택한다.

아래 예시는 Label 컨트롤의 안쪽 여백을 5만큼 주는 코드이다.

```css
Label {
    -fx-padding: 5;
}
```

이러면 모든 Label 컨트롤에 안쪽 여백이 5만큼 설정된다.

- \#id 선택자

\#id 선택자는 동일한 id 속성값을 가지고 있는 컨트롤 및 컨테이너를 설정한다.

```css
#labelId {
    -fx-background-color: black;
    -fx-text-fill: yellow;
}
```

위와 같이 작성한 경우 `<Label fx:id="labelId" ... />`인 경우 모두 해당 스타일이 적용된다.

- .class 선택자

.class 선택자는 동일한 styleClass 속성값을 가지고 있는 컨테이너 및 컨트롤을 선택한다.

```css
.labelClass {
    -fx-background-color: blue;
    -fx-text-fill: white;
}
```

`<Label styleClass="labelClass" ... />` 로 작성시에 해당 스타일을 얻게 된다.

FXML에서 `id 속성은 유일한 값`을 가져야 하지만, `styleClass 속성은 중복된 값`을 가질 수 있다.

즉, `id선택자`는 하나의 속성의 스타일만 설정하고, `styleClass선택자`는 여러 컨트롤을 선택할 수 있다.

또한, Type선택자와 class 선택자를 같이 사용할 수 있다.

```css
Label.className {
    -fx-background-color: blue;
    -fx-text-fill: white;
}
```

위와 같이 작성하면 `Label` 컨트롤 중 `styleClass="className"`을 가진 것만 해당 CSS가 적용된다.

---

> 컨트롤의 상태

컨트롤은 3가지 상태를 가질 수 있다.

- focused (입력 가능한 상태)
- hover (마우스가 컨트롤 위에 있는 상태)
- pressed (마우스가 컨트롤을 누른 상태)

위 값은 선택자 뒤에 `:`를 적은 후, 작성하면 된다. ex) `Label.className:hover { ... }`