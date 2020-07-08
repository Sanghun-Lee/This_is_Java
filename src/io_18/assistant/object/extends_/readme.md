#### writeObejct()와 readObject() 메소드

두 클래스가 상속 관계에 있을 때,

부모 클래스가 Serializable 인터페이스를 구현하고 있으면,

자식 클래스는 Serializable 인터페이스를 구현하지 않아도 자긱 객체를 직렬화 할 수 있다.

하지만, 자식 객체만 Serializable 인터페이를 구현하고, 부모는 구현하고 있지 않을 땐

두 가지 방법으로 해결할 수 있다.

1. 부모 클래스가 Serializable 인터페이스를 구현하도록 한다.
2. 자식 클래스에서 `writeObject()`와 `readObejct()` 메소드를 선언해서 부모 객체 필드를 직접 출력시킨다.

1번 방법은 부모 클래스의 수정이 불가능 할 때 에는 사용할 수 없다.

`writeObject` 메소드와 `readObject` 메소드는 직렬화, 역직렬화 할 때 자동으로 호출된다.

> 사용 예시

```java
private void writeObject(ObjectOutputStream out) throws IOException {
    out.writeXXX(부모 필드);        // 부모 객체의 필드값을 출력
    // ...
    out.defaultWriteObject();   // 자식 객체의 필드값을 직렬화
}
```

writeObject와 readObject 메소드는 `private`으로 선언해야 한다.

