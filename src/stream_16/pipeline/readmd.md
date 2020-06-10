### 중간처리와 최종처리

1. 남자만 필터링
2. 남자의 나이로 매핑
3. 남자 평균 나이 집계

위 3가지의 중간처리 및 최종처리를 하면 아래 코드와 같다.

```java
Stream<Member> maleFemaleStream = list.stream();
Stream<Member> maleStream = maleFemaleStream.filter(m -> m.getSex() == Member.MALE);
IntStream ageStream = maleStream.mapToInt(Member::getAge);
OptionalDouble optionalDouble = ageStream.average();
double ageAvg = optionalDouble.getAsDouble();
```

여기서 로컬 변수를 생략하면

```java
double ageAvg = list.stream()
    .filter(m -> m.getSex() == Member.MALE)
    .mapToInt(Member :: getAge)
    .average()
    .getAsDouble();
```

`filter(m -> m.getSex() == Member.MALE)` : 남자 Member 객체를 요소로 하는 새로운 스트림 생성

`mapToInt(Member :: getAge)` : Member 객체를 age 값으로 매핑해서 age를 요소로 하는 새로운 스트림 생성

`average()` : age 요소들의 평균을 OptionalDouble에 저장한다.

`getAsDouble()` : 저장된 평균값을 Double로 반환한다. 읽는다.