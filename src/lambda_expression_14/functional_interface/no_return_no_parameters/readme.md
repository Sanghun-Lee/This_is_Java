#### 매개변수와 리턴값이 없는 람다식

매개변수와 리턴값이 없는 함수형 인터페이스는 아래와 같이 생겼다.

```java
@FunctionalInterface
public interface InterfaceExample {
    public abstract void method();
}
```

> 추상 메소드가 하나만 있다.
>
> 추상 메소드의 매개변수와 리턴값이 없다.

람다식을 이용해서 해당 함수형 인터페이스를 구현하면 아래와 같다.

```java
public class Example {
    public static void main(String[] args) {
        InterfaceExample interfaceExample = () -> {
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
            public void method() {
                // 실행문
            }
        };
    }
}
```
