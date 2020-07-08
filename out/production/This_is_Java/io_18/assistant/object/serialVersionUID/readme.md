#### serialVersionUID 필드

직렬화된 객체를 역직렬화 할 때 `같은 클래스`를 사용해야 한다.

클래스의 이름이 다르거나, 내용이 변경되면 `InvalidClassException`이 발생한다.

이는 직렬화, 역직렬화 할 때 `serialVersionUID`값이 달라서 문제가 발생한다.

`Serializable` 인터페이스를 구현한 클래스는

컴파일 시에 자동으로 `serialVersionUID`값이 추가된다.

문제는 클래스의 필드 하나만 추가해도 `serialVersionUID` 값이 달라진다는 건데, 그래서 역직렬화에 실패하게 된다.

> 해결 방법

그래서 다음과 같이 serialVersionUID를 명시적으로 선언하면 된다.

```java
public class XXX implements Serializable {
    static final long serialVersionUID = 정수값;
}
```

