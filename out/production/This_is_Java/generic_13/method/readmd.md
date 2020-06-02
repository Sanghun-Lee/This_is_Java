### 제네릭 메소드

메소드의 매개변수 타입과 리턴 타입으로 타입 파라미터를 작는 메소드를 말한다.

선언 방법으로는

`[접근 지정자] <타입 파라미터> [리턴타입] [메소드명](매개면수, ...) { [메소드 내용] }`

와 같이 선언하고, 예시로는 아래와 같이 들 수 있다.

```java
public <T> int method1 (T t) { ... }
public <T> T method2(String str) { ... }
public <T> Box<T> method3(T t) { .... }
public static <K, V> boolean method(Pair<K, V> p1, Pair<K, V> p2) { .... }
```

호출하는 방법으론

`[리턴타입] [변수명] = <구체적 타입> [메소드 명] (매개값)`

으로 호출할 수 있고, 아래 예시와 같이 호출한다.

```java
Box<Integer> box = <Integer>boxing(100);
// or
Box<Integer> box = boxing(100);

boolean result = XXX.method<Integer, String>(p1, p2);
boolean result2 = XXX.method(p1, p2);   // p1과 p2로 제네릭을 유추한다.
```