### JavaFx 애플리케이션 개발 시작

#### 메인 클래스

예시 파일 : `AppMain.java`

JavaFx 애플리케이션을 시작하기 위해서는 javaFx.application.Application 클래스를 상속받고,

`start()` 메소드를 재정의 해야 한다.

그리고 `main()` 메소드에서 Application의 `launch()` 메소드를 호출해야 한다.

#### 메인 클래스의 실행 매개값 얻기

`init()` 메소드의 역할은 자바 프로그램 실행 시 실행 매개값을 얻어 App의 초기값으로 이용할 수 있다.

실행 명령 예제

```
java AppMain --ip=192.168.0.1 --port=8001
```

해당 매개값은 `main`함수의 `String[] args`에서 그대로 넘겨 받는데

아래와 같은 방법으로 해당 매개값을 받을 수 있다.

```
Parameters params = getParameters();
List<String> list = params.getRow();    // 여기까지 첫 번째 방법
Map<String, String> map = params.getNamed();    // 두 번째 방법
```

`params.getRow()` 메소드는 `"--ip=192.168.0.1"`, `"--port=8001"`를 요소로 갖는 List 컬렉션을 리턴한다.

`params.getNamed()`메소드는 key : `ip`, value : `192.168.0.1` / key : `port`, value : `8001`을 저장하는 Map을 리턴한다.

#### 무대(Stage)와 장면(Scene)

예시 파일 : `StageAndScene.java`

`start`메소드의 매개변수로 `Stage`타입의 객체를 받는다.

`Stage`가 JavaFx의 윈도우를 표현하게 된다. (JavaFx 윈도우위 최상위에 위치하게 된다.)

Stage는 하나의 장면만 올 수 있다. 그 장면이 바로 `Scene`객체이다.

`Scene`객체는 직접 생성해야 하고, 매개값으로 인터페이스 `Parent`의 구현 객체를 필요로 한다.

`Parents`가 루트 컨테이너가 되고, 해당 컨테이너에 여러가지 `버튼`과 `라벨`을 달아서 UI를 완성시킨다.

> Scene 객체 생성 방법

`Scene scene = new Scene(Parent);`

> Stage에 Scene 등록 방법

`stage.setScene(scene);`