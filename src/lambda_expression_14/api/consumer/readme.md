#### Consumer 함수적 인터페이스

Consumer 함수적 인터페이스는 리턴값이 없는 accept() 메소드를 가지고 있다.

accept() 메소드는 매개값을 사용만 할 뿐 리턴값이 없다.

코드로 표현하면 아래와 같은 형식을 갖는다.

```java
public interface Consumer<T> {
    @FunctionalInterface
    public abstract void accept(T t);
}
```

그래서 먼저 Consumer를 사용하려면

```java
class Consumer_Class<T> implements Consumer<T> {
    @Override
    void accept(T t) {
        // 실행문
    }
}
```

Consumer 인터베이스를 구현한 구현 클래스를 준비하고

```java
public class Main {
    public static void main(String[] args) {
        // 구현 클래스를 생성한 후
        Consumer<String> consumer = new Consumer_Class<String>();
        consumer.accept("...");  // 구현 클래스의 accept 메소드를 호출한다.
    }
}
```

이를 익명 구현 객체를 이용해서 구현하면 아래와 같다.

```java
public class Main {
    public static void main(String[] args) {
        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            void accept(Integer value) {
                // 실행문
            }
        };

        consumer.accept(3);
    }
}
```

Consumer는 `함수형 인터페이스`이기 때문에 람다식을 이용하면 아래와 같이 구현할 수 있다.

```java
public class Main() {
    public static void main(String[] args) {
        Consumer<String> consumer = (string) -> { /* ... */ };

        consumer.accept("abcd");
    }
}
```

매개변수의 타입과 수에 따라서 아래와 같은 Consumer들이 있다.

| 인터페이스명          | 추상 메소드                    | 설명                           |
| --------------------- | ------------------------------ | ------------------------------ |
| Consumer\<T>          | void accept(T t)               | 객체 T를 받아서 소비           |
| BiConsumer<T, U>      | void accept(T t, U u)          | 객체 T와 U를 받아 소비         |
| DoubleConsumer        | void accept(double value)      | double 값을 받아 소비          |
| IntConsumer           | void accept(int value)         | int 값을 받아 소비             |
| LongConsumer          | void accept(long value)        | long 값을 받아 소비            |
| ObjDoubleConsumer\<T> | void accept(T t, double value) | 객체 T와 double 값을 받아 소비 |
| ObjIntConsumer\<T>    | void accept(T t, int value)    | 객체 T와 int 값을 받아 소비    |
| ObjLongConsumer\<T>   | void accept(T t, long value)   | 객체 T와 long 값을 받아 소비   |
