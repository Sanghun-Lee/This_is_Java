#### Supplier 함수적 인터페이스

Supplier 함수적 인터페이스는 매개변수가 없고 리턴값이 있는 getXXX() 메소드를 가지고 있다.

그래서 Supplier의 인터페이스는 아래와 같이 생겼다.

```java
@FunctionalInterface
public interface Supplier<T> {
    T get();
}
```

리턴 타입에 따라서 아래와 같은 Supplier 함수적 인터페이스가 있다.

| 인터페이스명    | 추상 메소드            | 설명              |
| --------------- | ---------------------- | ----------------- |
| Supplier\<T>    | T get()                | T 객체를 리턴     |
| BooleanSupplier | boolean getAsBoolean() | boolean 값을 리턴 |
| DoubleSupplier  | double getAsDouble()   | double 값을 리턴  |
| IntSupplier     | int getAsInt()         | int 값을 리턴     |
| LongSupplier    | long getAsLong()       | long 값을 리턴    |

Supplier는 `interface`이고, 함수적 인터페이스 API에 대해 자세히 이해하려면 consumer의 readme를 참고하면 될 것 같다.

여기선 기본적인 Supplier의 사용법에 대해서 살펴보겠다.

Supplier의 사용법은

`Supplier<String> supplier = () -> { ...; return String; }`

IntSupplier는

`IntSupplier supplier = () -> { ....; return int_value; }`

그래서 예제는 주사위의 숫자를 랜덤하게 공급하는 IntSupplier 인터페이스를 타겟 타입으로 하는 람다식이다.
