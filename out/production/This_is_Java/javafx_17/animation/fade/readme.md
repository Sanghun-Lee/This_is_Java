#### 화면 이동

화면을 이동하는 가장 쉬운 방법은 `Stage`에 `새로운 Scene`을 세팅하는 것이다.

코드로는 아래와 같이 작동할 수 있다.

```java
public void handleButtonLogin(ActionEvent e) {
    try {
        Parent login = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(login);
        Stage primaryStage = (Stage) buttonLogin.getScene().getWindow();
        primaryScene.setScene(scene);
    } catch(Exception e) {
        e.printStackTrace();
    }
}
```

---

##### 애니메이션

애니메이션을 적용하려면 이전화면과 다음화면이 공존하여야 한다.

그래서 `StackPane`을 이용하면 화면 이동 효과와 함께 애니메이션을 적용할 수 있다.

방법으로는 Scene은 하나만 생성하고, `StackPane을 루트 컨테이너`로 해서

`메인 화면과 로그인 화면을 추가`하는 것이다.

로그인 버튼을 클릭하면 로그인 화면이 생성되고 `StackPane에 추가된다`.

StackPane은 나중에 추가된 로그인 화면만 사용자에게 보여주고, 메인 화면은 뒤로 숨긴다.

반대로 [메인]버튼을 클릭하면 StackPane에서 로그인 화면만 제거해서 그 아래에 있는 메인화면이 나타난다.