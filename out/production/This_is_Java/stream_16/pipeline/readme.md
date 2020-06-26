### 16.3 스트림 파이프라인

대량의 데이터를 가공 및 축소하는것을 일반적으로 `리덕션`이라 하는데

데이터의 `합계, 평균값, 카운팅, 최댓값, 최소값` 등이 대표적인 리덕션의 결과물이다.

하지만 이런 요소들로 바로 결과물을 낼 수 없을때는 집계하기 좋도록 `필터링, 매핑, 정렬, 그룹핑 등의 중간처리`가 필요하다.

### 중간처리와 최종처리

중간 처리란, 최종 처리를 제외하고는 모두 중간 처리 스트림이다.

예를들어 남자 평균 나이를 집계해야한다고 가정해 보자.

그러면 전체 데이터에서

1. 남자만 먼저 필터핑을 하고
2. 필터링된 결과에서 나이만 따로 빼 와야 한다.

위 두 과정을 `중간 처리`라고 한다.

그리고 마지막으로 `필터링 되서 나온 남자의 나이의 평균을 계산하는 것`

이를 `최종 처리`라고 한다.

1. 남자만 필터링
2. 남자의 나이로 매핑
3. 남자 평균 나이 집계

위 3가지의 중간 처리 및 최종 처리를 하면 아래 코드와 같다.

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