### 데몬 스레드

데몬 스레드 : 주 스레드의 작업을 돕는 보조적인 역할을 수행하는 스레드

주 스레드가 종료되면 데몬 스레드도 자동으로 종료된다.

`주 스레드 종료시에 자동으로 같이 종료되어야 하는 스레드일 경우 해당 스레드를 주 스레드의 데몬 스레드로 만든다.`

데몬 스레드 만드는 방법

```java
Thread1 thread1 = new Thread1();
thread1.setDaemon(true);    // setDaemon 함수를 true로 호출해서 데몬 스레드로 만든다.
thread1.start();            // 반드시 start하기 전에 setDaemon 메소드를 호출해야 한다.
```