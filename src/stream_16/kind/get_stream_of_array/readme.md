#### 16.2.2 배열로부터 스트림 얻기

`Arrays.stream(...)`을 이용해서 배열의 스트림을 얻는다.

> String 배열에서 stream 얻기

```java
String[] strArray = { "홍길동", "신용권", "김미나" };
// String이 객체 타입이라서 Stream<String> 을 리턴한다.
Stream<String> stringStream = Arrays.stream(strArray); 
```

> Int 배열에서 stream 얻기

```java
int[] intArray = { 1, 2, 3, 4, 5};
IntStream intStream = Arrays.stream(intArray);  // int stream을 리턴한다.
```