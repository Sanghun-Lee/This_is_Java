#### 채팅 서버 구현

채팅 서버를 구현해 보면서 `스레드 풀`, `ServerSocket`, `Socket`들이 어떻게 사용되는지 이해해 보자.

- ServerExample.java : 채팅 서버
    + startServer() : `start`버튼을 클릭시 실행되는 메소드
        - ExecutorService 생성
        - ServerSocket 생성 및 포트 바인딩
        - 연결 수락 코드
        
    + stopServer() : `stop`버튼을 클릭하면 실행되는 메소드
        - 메소드에 연결된 Socket 닫기
        - ServerSocket 닫기
        - ExecutorService 종료
        
    + Client 클래스 : `서버와 연결된 클라이언트들`의 정보를 가지고있는 클래스
        - receive() : 클라이언트로 부터 데이터를 받는다.
        - send() : 클라이언트로 데이터를 보낸다.
        
    + UI생성 코드
        
- app.css : UI의 스타일 설정

- ClientExample.java : 채팅 클라이언트
    + startClient() : `start`버튼 클릭시 실행되는 메소드
        - Socket 생성 및 연결 요청 코드
        
    + stopClient() : `stop`버튼을 클릭하거나, 서버 통신이 안될 경우 실행되는 메소드
        - Socket을 닫는 `close()` 메소드가 있다.
        
    + receive() : 서버에서 보낸 데이터를 받는 역할을 한다.
        - 작업 스레드상에서 호출된다.
        
    + send() : 사용자가 메시지를 입력하고 `send`버튼을 클릭하면 호출되는 메소드
        - 서버로 메시지를 보내는 역할을 한다.
        
    + UI생성 코드