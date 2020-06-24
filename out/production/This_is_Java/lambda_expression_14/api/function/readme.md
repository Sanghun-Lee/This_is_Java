#### Function 함수적 인터페이스

Function 함수적 인터페이스는 `매개값`과 `리턴값`이 있는 applyXXX() 메소드를 가진다.

그래서 Function 인터페이스는 아래와 같은 형태를 띄고있다.

```java
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}
```

주요한 함수적 인터페이스는 아래 두 가지가 있다.

| 인터페이스명          | 추상 메소드       | 설명                       |
| --------------------- | ----------------- | -------------------------- |
| Function<T, R>        | R apply(T t)      | 객체 T를 객체 R로 매핑     |
| BiFunctional<T, U, R> | R apply(T t, U u) | 객체 T와 U를 객체 R로 매핑 |

Function 인터페이스는 일반적으로 타입 변환에 사용되고, 아래와 같이 사용할 수 있다.

```java
Function<Student, String> function = t -> { return t.getName(); }
// 또는
Function<Student, String> function = t -> t.getName();
```

해당 예시에선 메소드의 매개변수로 인터페이스 변수를 받았다.

```java
public static void printString(Function<Student, String> function) {
    // ...
    function.apply(student);
}
```

그래서 호출시에 익명객체를 생성해서 호출하였다.

```java
public static void main(String[] args){
    printString(new Function<Student, String>() {
        @Override
        String apply(Student t) {
            return t.getName();
        }
    });

    // 이를 람다식을 이용하면 아래와 같다.
    printString(t -> t.getName());
}
```
