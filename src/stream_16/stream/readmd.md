## Stream

stream이란?

- 컬렉션의 저장 요소를 하나씩 참조해서 람다식으로 처리할 수 있도록 해주는 반복자 이다.

기존에 Iterator 반복자를 다음과 같이 사용했다.

```java
List<String> list = Arrays.asList("aaa", "bbb", "ccc");
Iterator<String> iterator = list.iterator();
while(iterator.hasNext()) {
    String name = iterator.next();
    System.out.println(name);
}
```

위 코드를 `Stream`을 사용하면 다음과 같다.

```java
List<String> list = Arrays.asList("aaa", "bbb", "ccc");
Stream<String> stream = list.stream();
stream.forEach(name -> System.out.println(name));
```

Stream의 `forEach`메소드는 Consumer 함수적 인터페이스 타입을 가지고 있다.

### Stream의 특징

1. 람다식으로 요소 처리 코드를 제공한다.

람다식은 함수적 인터페이스를 가지기 때문에, 메소드 참조를 이용해서 요소 처리 내용을 매개값으로 전달할 수 있다.

`LambdaExpressionsExample.java`, `Student.java` 파일 참고

2. 내부 반복자를 사용해서 병렬 처리가 쉽다.

Stream의 경우 컬렉션 내부에서 요소들을 반복시키기 때문에, 요소 처리 코드에만 집중할 수 있다. (hasNext와 같은 코드를 고려할 필요가 없다.)

`ParallelExample.java` 파일 참고

3. 스트림은 중간 처리과 최종 처리를 할 수 있다.

`MapAndReduceExample.java` 파일 참고