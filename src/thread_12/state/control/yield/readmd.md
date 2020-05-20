### Yield 메소드

다른 스레드에게 실행을 양보할 때 사용하는 메소드이다.

아래와 같은 상황일 때, yield를 호출해서 다른 스레드에게 자원을 양보한다.

```java
public void run() {
    while(true) {
        if(work) {
            // thread의 작업 내용
        }
    }
}
```

work가 false이면 해당 thread는 의미없는 작업만 반복하기 때문에 yield메소드로 다른 thread에게 자원을 양보하자.

```java
public void run() {
    while(true) {
        if(work) {
            // thread의 작업 내용
        }
        else {
            Thread.yield();
        }
    }
}
```