### 인터페이스 상속

| 파일 명         | 역할                                        |
| --------------- | ------------------------------------------- |
| InterfaceA      | 상위 인터페이스1이 선언된 파일              |
| InterfaceB      | 상위 인터페이스2가 선언된 파일              |
| InterfaceC      | InterfaceA, InterfaceB를 상속한 파일        |
| ImplementationC | InterfaceC를 구현한 구현 클래스             |
| Example         | ImplementationC를 생성후, 호출하는 메인파일 |

인터페이스 간에도 상속이 가능하다.

인터페이스는 <strong>다중상속을 허용한다.</strong>

인터페이스간의 상속

```java
public interface 하위인터페이스 extends 상위인터페이스1, 상위인터페이스2 {
// ...
}
```

하위 인터페이스를 구현하는 경우 상위인터페이스1, 2, 모두 `Override` 해야 한다.

해당 파일은 `interfaceA` : 상위 인터페이스1, `interfaceB` : 상위 인터페이스2, `interfaceC` : A, B를 상속한 하위 인터페이스 이다.

그리고 `ImplementationC` class가 interfaceC의 구현 클래스가 될 때

아래와 같이 3가지 호출이 가능하다.

```java
InterfaceA a = new ImplementationC();
InterfaceB b = new ImplementationC();
InterfaceC c = new ImplementationC();
```

`a`의 경우 `InterfaceA` 에서 선언한 메소드만 호출할 수 있고,

`b`의 경우 `InterfaceB`에서 선언한 메소드만,

`c`의 경우 `InterfaceA, InterfaceB, InterfaceC`에서 선언한 메소드만 호출할 수 있다.
