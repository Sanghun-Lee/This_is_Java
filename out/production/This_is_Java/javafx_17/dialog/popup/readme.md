#### popup

팝업은 투명한 컨테이너를 제공하는 `모달리스` 다이얼로그 이다.

popup의 UI는 `FXML`파일에서 작업하고

java 클래스 파일에서 다음과 같이 부르면 된다.

```java
Popup popup = new Popup();
popup.getContent().add(FXMLLoader.load(getClass().getResource("popup.fxml")));

// popup 실행
popup.show(primaryStage);       // 정 중앙에 실행
popup.show(primaryStage, anchorX, anchorY); // (anchorX, anchorY)에 실행
```

> popup 닫기

popup은 가장 최상단 위치에 놓이게 된다.

그래서 닫기 위해선 주 윈도우 (소유자 윈도우)를 닫거나 `hide()` 메소드를 호출해야 한다.

그리고 `setAutoHide(true)`를 설정할 수 있는데, 이는 마우스 클릭이 popup 밖을 클릭하면

자동으로 popup이 닫힌다.