### Thread의 상태 출력

Thread.start()를 호출 했을 때 바로 실행되는것이 아닌, 스케줄러에 의해 실행된다.

thead의 상태는 아래와 같다.

> new           - Thread 객체 생성<br>
> running       - 실행 상태<br>
> runnable      - 실행 대기 상태<br>
> terminated    - 종료 상태

그리고 그 외에도 `일시 정지` 상태가 있다.

일시 정지 상태는 

1. WAITING
2. TIMED_WAITING
3. BLOCKED

상태가 될 수 있다.

---
그래서 Thread에서 스레드의 상태를 확인할 수 있는 메소드가 있다.

`Thread.getState()`

해당 메소드를 호출하면 Thread.State 열거 상수를 리턴한다.

> NEW : thread가 생성, 아직 start() 되지 않은 상태<br>
> RUNNABLE : 실행대기상태<br>
> WAITING : 다른 스레드가 통지할 때까지 기다리는 상태<br>
> TIMED_WAITING : 주어진 시간동안 기다리는 상태<br>
> BLOCKED : 사용하고자 하는 객체의 락이 풀릴 때 까지 기다리는 상태<br>
> TERMINATED : 실행을 마친 상태<br>