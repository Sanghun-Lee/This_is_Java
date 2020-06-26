### 수집 (collect())

스트림은 요소들을 필터링 또는 매핑한 후 요소들을 수집하는 최종 처리 메소드인 collect()를 제공한다.

수집이란, 필터링 또는 매핑된 요소들로 구성된 새로운 컬렉션을 생성한다.

collect 메소드 형태

`R collect(Collector<T, A, R> collector)` - T 요소를 A 누적기가 R에 저장한다.

A인 누적기는 일반적으로 `?`가 들어간다.

이것은 Collector가 R(컬렉션)에 T(요소)를 저장하는 방법을 알고있어 A(누적기)가 필요 없기 때문이다.

collect는 다음과 같은 정적 메소드를 이용해서 얻을 수 있다.

| 리턴 타입 | Collectors의 정적 메소드 | 설명 |
| --- | --- | --- |
| Collector<T, ?, List\<T>> | toList() | T를 List에 저장 |
| Collector<T, ?, Set\<T>> | toSet() | T를 Set에 저장 |
| Collector<T, ?, Collection\<T>> | toCollection(Supplier<Collection\<T>>) | T를 Supplier가 제공한 Collection에 저장 |
| Collector<T, ?, Map<K, U>> | toMap(Function<T, K> keyMapper, Function<T, U> valueMapper) | T를 K와 U로 매핑해서 K를 키로, U를 값으로 Map에 저장 |

그래서 `collect(Collectors.toList())`를 선언하면 필터링 한 요소들이 List로 저장된다.

예시로 하나 들어보면 아래와 같다.

```java
Stream<Student> totalStream = totalList.stream();
Stream<Student> maleStream = totalStream.filter(s -> s.getSex() == Student.Sex.MALE);
// 여기까지 남학생만 필터링해서 Stream을 얻는다.

// List에 Student를 수집하는 Collector를 얻는다.
Collector<Student, ?, List<Student>> collector = Collectors.toList();

// Stream에서 collect() 메소드로 Student를 수집해서 새로운 List를 얻는다.
List<Student> maleList = maleStream.collect(collector);
```

여기서 로컬 변수를 생략하면 다음과 같아진다.

```java
List<Student> maleList = totalList.stream()
    .filter(s -> s.getSex() == Student.Sex.MALE)
    .collect(Collectors.toList())
```

