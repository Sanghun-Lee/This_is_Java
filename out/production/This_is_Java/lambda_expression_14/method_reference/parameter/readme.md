#### 매개변수의 메소드 참조

14.6.1 (method)에서는 해당 람다식 외부의 클래스 멤버인 메소드를 호출하였다.

```
operator = (x, y) -> Calculator.staticMethod(x, y);

operator = Calculator::staticMethod;
```

위 두 함수 모두 x, y와 관련없는 외부 클래스 멤버 메소드를 호출하였다.

하지만 아래와 같이 람다식의 매개변수의 메소드를 호출하는 경우도 있다.

`(a, b) -> { a.instanceMethod(b); }`

예를 들면

`(a, b) -> { a.compareToIgnoreCase(b); }` 처럼 그렇다.

그래서 이를 메소드 참조로 표현하면 다음과 같다.

`클래스 :: instanceMethod`

ArgumentMethodReferenceExample 파일을 살펴보면

```java
// 기존의 방법
function = (a, b) -> a.compareToIgnoreCase(b);

// 메소드 참조를 이용한 방법
function = String::compareToIgnoreCase;
```

이 될 수 있다.
