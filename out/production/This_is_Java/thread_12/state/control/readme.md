### Thread의 상태를 제어하는 방법

Thread의 상태를 변화시키는 메소드들

> interrupt() : 일시 정지 상태의 스레드에서 InterruptException 예외를 발생시킨다. <br>
> notify(), notifyAll() : 동기화 블록 내에서 wait() 메소드에 의해 일시 정지 상태에 있는 스레드를 실행 대기 상태로 만든다.<br>
> ~~resume() : suspend() 메소드에 의해 일시 정지 상태에 있는 스래드를 실행 대기 상태로 만든다.~~ <br>
> sleep(long millis), sleep(long millis, int nanos) : thread를 일시 정지 시킨다. <br>
> join() / join(long millis) / join(long millis, int nanos) : 
> wait() : 동기화 블록 내에서 스레드를 일시 정지 상태로 만든다.