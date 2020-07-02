### JavaFx 속성 감시와 바인딩

JavaFx는 컨트롤(컴포넌트들 (버튼, 레이블...))의 속성(상태)를 감시하는 리스너를 설정할 수 있다.

예를 들어 `Slider` 컨트롤의 `value`속성값을 감시해서 `값이 변경되면 호출하는 리스너`를 설정할 수 있다.

#### 속성 감시

컨트롤의 속성을 얻기 위해선 `XXXProperty` 메소드를 사용하면 된다.

slider의 속성 객체 얻기 : `slider.valueProperty()`

속성을 감시하는 객체에서 `addListener` 메소드를 이용해서 값 변화에 대한 리스너를 추가할 수 있다.

```java
Slider slider = new Slider();
slider.valueProperty().addListener(new ChangeListener<Number> () {
    @Override
    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        // ...
    }
})
```

`slider`의 값이 변경되면 `ChangeListener`의 `change()`메소드가 자동으로 실행된다.

속성의 이전 값은 `oldValue`에, 새로운 값은 `newValue`에 매개값으로 전달된다.