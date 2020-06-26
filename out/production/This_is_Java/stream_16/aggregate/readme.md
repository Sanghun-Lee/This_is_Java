### 16.9 기본 집계

기본 집계는 아래와 같고 최종 처리 기능이다.

- sum()
- count()
- average()
- max()
- min()

집계는 대량의 데이터를 가공해서 축소하는 리덕션 이라고 볼 수 있다. 

스트림은 다음과 같은 기본 집계 메소드를 제공하고 있다.

| 리턴 타입 | 메소드 (매개 변수) | 설명 |
| --- | --- | --- |
| long | count() | 요소 개수 |
| OptionalXXX | findFirst() | 첫 번째 요소 |
| Optional\<T> | max(Comparator\<T>) | 최대 요소 |
| OptionalXXX | max() | 최대 요소 |
| Optional\<T> | min(Comparator\<T>) | 최소 요소 |
| OptionalXXX | min() | 최소 요소 |
| OptionalDouble | average() | 요소 평균 |
|int, long, double | sum() | 요소 총합 |

> OptionalXXX
>
> OptionalXXX는 자바 8에서 추가한 java.util 패키지의 
>
> Optional, OptionalDouble, OptionalInt, OptionalLong 클래스 타입을 말한다.
>
> 이들은 값을 저장하는 값 기반 클래스 (value-base class)들이다.
>
> 해당 객체에서 값을 얻기 위해선 get(), getAsDouble(), getAsInt(), getAsLong()을 호출하면 된다.

---

`AggregateExample.java` : 스트림이 제공하는 기본 집계를 사용한 예시

`OptionalExample.java` : Optional 클래스에 대한 예시

#### Optional 클래스

Optional 클래스들은 저장하는 값의 타입만 다를 뿐 제공하는 기능은 거의 동일하다.

Optional 클래스는 단순히 집계 값을 저장하는 것이 아니라,

집계 값이 존재하지 않을 경우 `디폴트 값`을 설정할 수 있다.

그리고 집계 값을 처리하는 `Consumer`도 등록할 수 있다.

> 값이 저장되어 있는지 확인하는 isPresent

아래와 같은 코드에서 list에 값이 없으면 어떻게 될 까

```java
List<Integer> list = new ArrayList<>();
double avg = list.stream().mapToInt(Integer :: intValue).average().getAsDouble();
System.out.println("평균 : " + avg);
```

list에 요소가 없기 때문에 avg값은 없고, 그래서 `NoSuchElementException` 예외가 발생한다.

그래서 아래와 같이 평균값 여부를 확인할 수 있다.

```java
OptionalDouble optional = list.stream().mapToInt(Integer :: intValue).average();

if(optional.isPresent()) {
    System.out.println("평균 : " + optional.getAsDouble());
} else {
    System.out.println("평균 : " + 0.0);
}
```

> 디폴트 값 설정

`T/double/int/long orElse(T/double/int/long value)`

메소드를 이용해서 값이 없으면 value 값으로 디폴트 값을 정할 수 있다.

```java
double avg = list.stream().mapToInt(Integer::intValue).average().orElse(0.0);
```

> 평균값이 있을 때 만 이용

`void ifPresent(Consumer)`

해당 메소드를 이용해서 값이 있을 때만 Consumer 함수적 인터페이스를 실행할 수 있다.