#### 리턴값과 매개변수가 있는 람다식

리턴값과 매개변수가 있는 함수형 인터페이스는 아래와 같이 생겼다.

```java
@FunctionalInterface
public interface InterfaceExample {
    public abstract String method(int x, int y);
}
```

제네릭을 이용해서 매개변수를 표현하면 아래와 같다.

```java
@FunctionalInterface
public interface InterfaceExample<K, V> {
    public abstract V method(K k);
}
```

> 추상 메소드가 하나만 있다.
> 
> 추상 메소드에 매개변수와 리턴값이 존재한다.
>
> 매개변수는 한 개 이상 존재할 수 있다.

람다식을 이용해서 해당 함수형 인터페이스를 구현하면 아래와 같다.

```java
public class Example {
    public static void main(String[] args) {
        InterfaceExample<Integer, String> interfaceExample = (k) -> {
            // 실행문
            return v;
        };
    }
}
```

람다식 없이 구현하면 아래와 같다.

```java
public class Example {
    public static void main(String[] args) {
        InterfaceExample<Integer, String> interfaceExample = new InterfaceExample() {
            @Override
            public String method(Integer x) {
                // 실행문
            }
        };
    }
}
```