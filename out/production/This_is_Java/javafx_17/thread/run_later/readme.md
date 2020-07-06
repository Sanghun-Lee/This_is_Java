#### 17.11.1 Platform.runLater() 메소드

작업스레드가 UI 변경 시, UI변경 코드를 `Runnable`로 생성하고

이를 매개값으로 해서 `Platform.runLater(Runnable);`로 UI 처리 요청을 JavaFx Application Thread에 보낼 수 있다.

```java
Platform.runLater(new Runnable() {
    @Override
    public void run() {
        // UI 변경 코드
        button.setText("hello");
    }
})
```

`runLater` 메소드는 이벤트 큐에 `Runnable 객체`를 넣고, 바로 리턴한다.

JavaFx Application Thread는 해당 이벤트 큐를 보고, 순서대로 작업을 처리해 준다.