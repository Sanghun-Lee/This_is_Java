#### UI 변경

Task의 call()은 작업 스레드상에서 실행되기 때문에 바로 UI 변경 코드를 작성할 수 없다.

그래서 call() 메소드 내부에서

- updateProgress()

- updateMessage()

- Platform.runLater()

위 3가지 메소드를 이용해서 UI 업데이트 할 수 있다.

---

> updateProgress()

진행 정도를 `ProgressBar`에 나타내는 경우가 종종있다.

`Task의 progress 속성`과 `ProgressBar의 progress 속성`이 `바인딩` 되어 있다면

작업 스레드에서 updateProgress() 메소드를 호출했을 때 ProgressBar의 상태가 변경된다.

```java
// 속성 바인딩
ProgressBar progressBar = new ProgressBar();
progressBar.progressProperty().bind(task.progressProperty());
```

- updateProgress()의 사용 : `updateProgress(double workDone, double max);`
    - workDone : 진행 상태
    - max : 진행 완료 값
    
예시

```java
Task<Void> task = new Task<Void> () {
    @Override
    protected Void call() throws Exception {
        for(int i = 1; i <= 100; i++) {
            if(isCancelled()) { break; }
            // 작업 코드
            updateProgress(i, 100);
        }
        return null;
    }
};

// progress 속성 바인딩
ProgressBar progressBar = new ProgressBar();
progressBar.progressProperty().bind(task.progressProperty());   // 속성 바인딩

// 작업 스레드 시작
Thread thread = new Thead(task);
thread.start();
```

---

> updateMessage() 메소드

작업이 진행중이거나, 취소되었을 경우, 문자열 메시지를 전달해서 UI를 변경하고 싶다면

`updateMessage(String message)`를 호출할 수 있다.

updateMessage는 Task의 message 속성을 업데이트 한다.

그래서 `Task의 message 속성`와 UI 컨트롤의 `문자열 속성`을 바인딩 할 수 있다.

예시

```java
Task<Void> task = new Task<Void> () {
    @Override
    protected Void call() throws Exception {
        for(int i = 1; i <= 100; i++) {
            if (isCancelled()) { break; }
            updateMessage(String.valueOf(i));   // Task의 message 속성 업데이트
        }
        return null;
    }
};

// 문자열 속성 바인딩
Label label = new Label();
label.textProperty().bind(task.messageProperty());  // 속성 바인딩

// 작업 스레드 시작
Thread thread = new Thread(task);
thread.start();
```

---

> Platform.runLater() 메소드

상위 파일의 `Platform.runLater()`와 동일하다.

예시

```java
Task<Integer> task = new Task<Integer>() {
    @Override
    protected Integer call() throws Exception {
        for(int i = 1; i <= 100; i++) {
            if (isCancelled()) { break; }
            Platform.runLater( () -> { // UI 변경 코드 });
        }
        return result;
    }
};

// 작업 스레드 시작
Thread thread = new Thread(task);
thread.start();
```