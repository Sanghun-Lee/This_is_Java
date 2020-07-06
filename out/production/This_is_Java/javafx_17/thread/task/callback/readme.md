#### 작업 상태별 콜백

작업이 어떻게 처리되었는지에 따라 Task의 다음 세 가지 메소드 중 하나가 `자동 호출(콜백)` 된다.

| 콜백 메소드 | 설명 |
| --- | --- |
| succeeded() | 성공적으로 call() 메소드가 리턴되었을 때 |
| cancelled() | cancel() 메소드로 작업이 취소되었을 때 |
| failed() | 예외가 발생되었을 때 |

위 메소드들은 `Task에 정의`되어 있기 때문에, `재정의`해서 개발자 마음대로 만들 수 있다.

해당 메소드들은 `JavaFx Application Thread에서 호출`되기 때문에, UI 변경 코드를 작성할 수 있다.

> succeeded() 예시

```java
@Override
protected void succeeded() {
    V v = task.getValue();
}
```

`call()` 메소드가 리턴값이 있을경우 `getValue() 메소드`로 리턴값을 받을 수 있다. 