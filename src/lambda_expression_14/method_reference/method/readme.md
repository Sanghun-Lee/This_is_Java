#### 14.6.1 정적 메소드와 인스턴스 메소드 참조

정적 메소드의 참조 방법

`클래스 :: 메소드`

예시

```java
// 기존의 방법
operator = (x, y) -> Calculator.staticMethod(x, y);

// 메소드 참조
operator = Calculator::staticMethod;
```

인스턴스 메소드 참조

`참조변수 :: 메소드`

예시

```java
Calculator obj = new Calculator();  // 객체 생성

// 기존의 방법
operator = (x, y) -> obj.instanceMethod(x, y);

// 메소드 참조
operator = obj :: instanceMethod;
```
