### 메소드 참조

메소드를 참조해서 람다식에서 불필요한 매개 변수를 제거하는 것이 목적이다.

다음과 같은 람다식이 있을 때

`(left, right) -> Math.max(left, right);`

해당 람다식은 단순히 두 개의 값을 Math.max() 메소드의 매개값으로 전달하는 역할만 한다.

그래서 이를 메소드 참조로 단순하게 만들 수 있다.

`Math::max;`

그래서 람다식api에서 다음과 같이 사용할 수 있다.

```
IntBinaryOperator operator = (left, right) -> Math.max(left, right);
// 위를 아래로
IntBinaryOperator operator = Math :: max;
```

| 챕터   | 패키지      | 설명                               |
| ------ | ----------- | ---------------------------------- |
| 14.6.1 | method      | 정적 메소드와 인스턴스 메소드 참조 |
| 14.6.2 | parameter   | 매개 변수의 메소드 참조            |
| 14.6.3 | constructor | 생성자 참조                        |
