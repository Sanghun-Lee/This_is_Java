### join 메소드

다른 스레드의 연산이 끝나고 나서 계속 진행되어야 할 경우

join 메소드로 스레드를 일시정지 상태로 만들어 주자.

`ThreadA`와 `ThreadB`가 있을 때

ThreadA의 연산이 끝나고 난 후, ThreadB가 실행되는 과정을 필요로 할 때

ThreadB에서 ThreadA의 join을 호출하면 `(ThreadA.join())`

A의 연산이 끝난 후, B의 연산을 시작한다.