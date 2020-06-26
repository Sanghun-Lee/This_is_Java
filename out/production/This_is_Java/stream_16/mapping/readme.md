### 16.5 매핑

mapping(매핑)은 `중간 처리 기능`으로 스트림의 요소를 다른 요소로 대체하는 작업을 말한다.

스트림에서 제공하는 매핑 메소드는 아래와 같고, 하나씩 살펴보자

- flatXXX()
- mapXXX()
- asDoubleStream()
- asLongStream()
- boxed()

> flatMapXXX() 메소드

`예시 파일 : FlatMapExample.java`

flatMapXXX 메소드는 요소를 대체하는 복수 개의 요소들로 구성된 새로운 스트림을 리턴한다.

기본 메소드 타입은 `Stream<R> flatMap(Function<T, Stream<R>>)` 형태이다.

T를 받아서 Stream<R> 형태로 변환한다.

해당 예제에서는 `List<String>`을 받아서 `Stream<String>`으로 변환했다.

