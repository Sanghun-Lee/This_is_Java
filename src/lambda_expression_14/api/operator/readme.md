#### operator 함수적 인터페이스

operator 함수적 인터페이스는 Function과 동일하게 매개 변수와 리턴값이 있는 applyXXX() 메소드를 가지고 있다.

일반적으로 연산을 수행한 후, 동일한 타입으로 리턴값을 제공하는 역할을 한다.

매개변수 타입과 값에 따라서 아래와같은 Operator 함수적 인터페이스가 존재한다.

| 인터페이스명         | 추상 메소드                           | 설명                     |
| -------------------- | ------------------------------------- | ------------------------ |
| BinaryOperator\<T>   | BiFunction<T, T, T>의 하위 인터페이스 | T와 U를 연산한 후 R 리턴 |
| UnaryOperator        | Function<T, T>의 하위 인터페이스      | T를 연산한 후 T 리턴     |
| DoubleBinaryOperator | double applyAsDouble(double, double)  | 두 개의 double 연산      |
| DoubleUnaryOperator  | double applyAsDouble(double)          | 한 개의 double 연산      |
| IntBinaryOperator    | int applyAsInt(int, int)              | 두 개의 int 연산         |
| IntUnaryOperator     | int applyAsInt(int)                   | 한 개의 int 연산         |
| LongBinaryOperator   | long applyAsLong(long, long)          | 두 개의 long 연산        |
| LongUnaryOperator    | long applyAsLong(long)                | 한 개의 long 연산        |

`IntBinaryOperator` 인터페이스를 타겟 타입으로 하는 람다식은 다음과 같이 작성할 수 있다.

`IntBinaryOperator operator = (a, b) -> { ...; return int_value; }`

OperatorExample.java의 예제도 Function처럼 메소드의 매개변수에 인터페이스 변수를 요청하고

이를 메인에서 람다식을 이용한 익명 구현 객체를 넘겨주어서 operator를 구현하였다.

---

#### minBy(), maxBy() 정적 메소드

BinaryOperator<T> 함수적 인터페이스는 minBy(), maxBy() 정적 메소드를 제공한다.

매개값으로 제공되는 Comparator를 이용해서 최대 T와 최소 T를 얻는 BinaryOperator<T>를 리턴한다.

| 리턴 타입          | 정적 메소드                             |
| ------------------ | --------------------------------------- |
| BinaryOperator\<T> | minBy(Comparator<? super T> comparator) |
| BinaryOperator\<T> | maxBy(Comparator<? super T> comparator) |

> Comparator\<T>
>
> Comparator\<T>는 다음과 같은 함수적 인터페이스이다.

```java
@FunctionalInterface
public interface Comparator<T> {
    public int compare(T o1, T o2);
}
```

> o1 < o2 이면 음수를 리턴
>
> o1 == o2 이면 0을 리턴
>
> o1 > o2 이면 양수를 리턴한다.
