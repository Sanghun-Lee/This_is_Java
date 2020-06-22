### 디폴트 메소드

| 파일 명              | 역할                               |
| -------------------- | ---------------------------------- |
| MyClassA             | MyInterface를 구현한 구현 클래스   |
| MyClassB             | MyInterface를 구현한 구현 클래스2  |
| MyInterface          | default method를 추가할 인터페이스 |
| DefaultMethodExample | InterfaceC를 구현한 구현 클래스    |

디폴트 메소드의 필요성

기존 인터페이스에 기능을 생성하면 (추상메소드를 추가하면) 해당 인터페이스를 구현한 모든 클래스는

해당 추상메소드를 재정의 해야한다.

만약에 해당 인터페이스를 구현한 클래스가 많다면 인터페이스를 고친다는 것은 거의 불가능한 일에 가깝게 된다.

그래서 default method를 추가해서 필요한 구현 클래스만 해당 default-method를 Override해서 사용하면 된다.
