#### 직렬화 가능한 클래스 (Serializable)

자바는 `Serializable` 인터페이스를 구현한 클래스만 적렬화 할 수 있도록 제한하고 있다.

Serializable 인터페이스는 필드나 메소드가 없는 `빈 인터페이스`이다.

객체를 직렬화 하면 필드의 값만 직렬화 된다. (`static필드`와, `transient필드`는 직렬화 되지 않는다.)

