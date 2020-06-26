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

해당 예제에서는 `String`을 받아서 `Stream<String>`으로 변환했다.

> mapXXX() 메소드

`예시 파일 : MapExample.java`

mapXXX() 메소드는 요소를 대체하는 요소로 구성된 새로운 스트림을 리턴한다.

기본 메소드 타입은 `Stream<R> map(Function<T, R>)` 형태이다.

T를 받아서 R 형태로 변환한다.

> asDoubleStream(), asLongStream(), boxed() 메소드

`예시 파일 : asDoubleStreamAndBoxedExample.java`

asDoubleStream은 int, long 요소를 double로 타입 변환 해준다.

asLongStream은 int를 long요소로 변환해서 LongStream을 생성한다.

boxed() 메소드는 int, long, double 요소를 Integer, Long, Double로 boxing해준다.