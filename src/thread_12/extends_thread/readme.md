## Thread를 class에서 extends 한 후, 생성

class에서 <strong>extends thread</strong> 를 작성한 후, (BeepThread.java)

run 메소드를 Override 한다.

main함수에서는

```java
Thread thread = new Extends_class(); // 이렇게 객체를 생성한다.
thread.start(); // start 메소드로 extneds class에서 Override 한 run 메소드가 실행된다.
```

