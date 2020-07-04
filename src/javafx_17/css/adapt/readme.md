#### CSS 파일 적용

외부 CSS 파일은 개별 컨테이너 또는 컨트롤에 적용하거나

Scene에 추가하여 Scene 내부의 모든 컨테이너와 컨트롤에 적용할 수 있다.

> fxml에 적용

`<컨테이너 styleSheet="@app.css">`

> Scene에 적용

`scene.getStylesheets().add(getClass().getResource("app.css").toString());`