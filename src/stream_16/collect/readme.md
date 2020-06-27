### 수집 (collect())

수집이란, 필터링 또는 매핑된 요소들 (최종처리가 끝난 요소들)로 구성된 새로운 컬렉션 (List, Set)을 생성하는 메소드이다.

collect 메소드 형태

`R collect(Collector<T, A, R> collector)` - T 요소를 A 누적기가 R에 저장한다.

> collect 메소드에 Collector 클래스의 객체를 대입해 주어야 한다.
>
> Collector 객체는 아래와 같는 collect의 정적 메소드를 이용해서 생성할 수 있다.

| 리턴 타입 | Collectors의 정적 메소드 | 설명 |
| --- | --- | --------------------- |
| Collector<T, ?, List\<T>> | Collectors.toList() | 요소(T)들을 List에 저장하는 Collector를 얻는다. |
| Collector<T, ?, Set\<T>> | Collectors.toSet() | 요소 (T)들을 Set에 저장하는 Collector를 얻는다.|
| Collector<T, ?, Map<K, U>> | Collectors.toMap(Function<T, K> keyMapper, Function<T, U> valueMapper) | T를 K와 U로 매핑해서 K를 키로, U를 값으로 Map에 저장 |
| Collector<T, ?, Collection\<T>> | Collectors.toCollection(Supplier<Collection\<T>>) | T를 Supplier가 제공한 Collection에 저장 |

그래서 `collect(Collectors.toList())`를 선언하면 필터링 한 요소들이 List로 저장된다.

`toCollection`은 Supplier가 제공하는 Collection에 수집을 진행한다.

> R이 List, Set인 경우 A는 `?`가 들어간다.
>
> List, Set과 같은 Collector가 R(컬렉션)에 T(요소)를 저장하는 방법을 알고 있어 A(누적기)가 필요없기 때문이다.

예시로 하나 들어보면 아래와 같다.

> 전체 학생 List에서 남학생들만 별도의 List로 생성하고 싶다.

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

---

#### 사용자 정의 컨테이너에 수집하기

개발자가 작성한 클래스에 객체를 수집하는 방법에 대해서 알아보도록 하자.

다음과 같은 `collect()` 메소드를 추가적으로 제공한다.

`R collect(Supplier<R>, BiConsumer<R, ? super T>, BiConsumer<R, R>)`

> Supplier 인터페이스 : 입력은 없고 return 값만 있는 인터페이스
>
> BiConsumer : 두 개의 객체를 받아서 소비하는 인터페이스

- Supplier : 요소들이 수집될 컨테이너 객체를 생성하는역할 (사용자 정의 컨테이너를 만드는 역할을 한다.)
    - single Thread 시에 단 한 번 Supplier가 실행
    - multi Thread 시에 스레드별로 Supplier가 실행된다.

- BiConsumer<R, ? super T> : 컨테이너 객체에 요소를 수집하는 역할을 한다.
    - 스트림에서 요소를 컨테이너에 수집할 때 마다 실행된다.
    
- BiConsumer<R, R> : 두 컨테이너 객체를 결합하는 역할을 한다.
    - single Thread : 실행되지 않는다.
    - multi Thread : 스레드별로 생성한 컨테이너를 해당 인터페이스를 이용해서 결합한다.
    
---

#### 요소를 그룹핑해서 수집