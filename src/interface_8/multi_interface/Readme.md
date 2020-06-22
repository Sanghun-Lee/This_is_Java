## 다중 인터페이스의 구현 클래스

인터페이스의 경우 다수의 인터페이스를 구현할 수 있다.

```
public class 구현클래스명 implements 인터페이스A, 인터페이스B {
    // 인터페이스A에 선언된 추상 메소드의 실체 메소드 선언
    // 인터페이스B에 선언된 추상 메소드의 실체 메소드 선언
}
```

그래서 해당 예제는 `RemoteControl` 인터페이스와 `Searchable` 인터페이스

두 개의 인터페이스가 존재한다.

그리고 이를 구현한 구현 클래스 `SmartTelevision`이 존재한다.

`SmartTelevision`이 두 개의 인터페이스를 모두 구현했기 때문에

아래와 같이 코드가 존재할 수 있다.

```java
SmartTelevision smartTV = new SmartTelevision();
RemoteControl remoteControl = smartTV;
Searchable searchable = smartTV;
```

그래서 `remoteControl`변수로 접근할 수 있는 메소드는

`RemoteControl`에 선언된 메소드와 필드들이고,

`Searchable`변수로 접근할 수 있는 메소드는

`Searchable`에 선언된 메소드와 필드이다.