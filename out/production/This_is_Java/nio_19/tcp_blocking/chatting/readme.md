#### 채팅 서버 구현

채팅 서버를 구현해 보면서 `ExecutorService`, `ServerSocketChannel`, `SocketChannel` 들이 어떻게 사용되는지 이해해보자.

- ServerExample.java
    - GUI 실행 화면에서 `start`버튼을 클릭하면 `startServer()`메소드가 호출된다.
    - start시에 start는 `stop`버튼으로 바뀌고, stop버튼을 누를 시, `stopServer()`메소드가 호출된다.

> startServer() 메소드

해당 메소드는 스레드 풀 생성, ServerSocketChannel 생성 및 port binding 연결 수락 코드가 존재한다.

> stopServer() 메소드

해당 메소드는 SocketChannel 닫기, ServerSocketChannel 닫기, 스레드 풀 종료를 실행한다.

