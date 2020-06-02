### Call back

콜백이란, 스레드에서 작업 처리를 요청한 후, 스레드가 작업을 완료하면 특정 메소드를 자동 실행하는 기법이다.

그래서 Future 의 get 메소드와 달리 block 되지않고, 프로그램이 계속 이어나가면서 실행될 수 있다.

call back 메소드는 `java.nio.channels.CompletionHandler`를 이용해서 만들 수 있다.

```java
CompletionHandler<V, A> callback = new CompletionHandler<V, A>() {
    @Override
    public void completed(V result, A attachment) {
        // 작업이 정상완료되었을 때 실행
    }
    
    @Override
    public void faild(Throwable exc, A attatchment) {
        // 작업 처리 도중 예외가 발생했을 때 실행
    }
}
```

V : 결과값의 타입

A : 첨부값의 타입 (첨부값 : 콜백 메소드에 결과값 이외에 추가적으로 전달하는 객체, 없으면 void)

> 콜백 하기

스레드에서 콜백 객체의 메소드를 호출한다.

```java
Runnable task = new Runnable() {
    @Override
    public void run() {
        try {
            // 작업 처리
            V result = ...;
            callback.completed(result, null);   // 작업을 정상 처리했을 경우 호출
        }   catch(Exception e) {
            callback.failed(e, null);           // 예외가 발생 했을 경우 호출
        }   
    }
}
```