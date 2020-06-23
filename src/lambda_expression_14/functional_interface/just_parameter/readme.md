#### 리턴값이 없고 매개변수만 있는 람다식

매개변수만 있는 함수형 인터페이스는 아래와 같은 형태를 가진다.

```java
@FunctionalInterface
public interface InterfaceExample {
    public abstract void method(int x);
}
```

제네릭을 이용해서 매개변수를 표현하면 아래와 같다.

```java
@FunctionalInterface
public interface InterfaceExample<T> {
    public abstract void method(T t);
}
```

> 추상 메소드가 하나만 있다.
>
> 추상 메소드가 리턴값이 없다.
>
> 추상 메소드에 매개변수만 존재한다.
>
> 매개변수는 한 개 이상 존재할 수 있다.

람다식을 이용해서 해당 함수형 인터페이스를 구현하면 아래와 같다.

```java
public class Example {
    public static void main(String[] args) {
        // 매개변수가 한개라서 "()" 괄호를 생략 가능하다.
        InterfaceExample interfaceExample = (x) -> {
            // 실행문
        };
    }
}
```

람다식 없이 구현하면 아래와 같다.

```java
public class Example {
    public static void main(String[] args) {
        InterfaceExample interfaceExample = new InterfaceExample() {
            @Override
            public void method(int x) {
                // 실행문
            }
        };
    }
}
```
