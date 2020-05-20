Thread에 이름을 설정할 수 있다.

큰 역할을 하는 것은 아니고, 디버깅 할 때 어떤 스레드가 어떤 작업을 하고 있는지 조사할 목적으로 사용된다.

메인 스레드는 main이라는 이름을 가지고 있다.

```java
thread.setName("thread_name");
```

set name 함수로 thread의 이름을 설정할 수 있다.

thread 이름을 알고 싶을 경우 getName() 메소드를 이용한다.

```java
thread.getName();
// thread의 이름을 리턴한다.
```


currentThread() 함수는 익명객체로 thread를 생성할 경우 참조를 가지고있지 않는데,

currentThread()함수는 해당 thread의 참조를 리턴해준다.

```java
Thread thread = Thread.currentThread();
```

예제는 메인 스레드의 참조를 얻어 스레드 이름을 콘솔에 출력하고, 새로 성성한 스레드의 이름을 setName()으로 설정한 후, getName()으로 읽어오도록 했다.
