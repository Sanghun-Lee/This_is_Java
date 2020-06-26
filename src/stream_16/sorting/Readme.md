### stream sorting

스트림은 중간 단계에서 요소를 정렬해서 최종 처리 순서를 변경할 수 있다.

요소를 정렬하는 메소드는 아래와 같다.

| 리턴 타입 | 메소드(매개 변수) | 설명 |
| --- | --- | --- |
| Stream<T> | sorted() | 객체를 Comparable 구현 방법에 따라 정렬 |
| Stream<T> | sorted(Comparator<T>) | 객체를 Comparator에 따라 정렬 |
| DoubleStream | sorted() | double 요소를 오름차순으로 정렬 |
| IntStream | sorted() | int 요소를 오름차순으로 정렬 |
| LongStream | sotred() | long 요소를 오름차순으로 정렬 |

객체 요소일 경우는 클래스가 Comparable을 구현한 요소만 sorted()를 호출해야 한다.

```java
public class Student implements Comparable<Student> {
    // ...
    
    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
```

Comparable 인터페이스는 함수형 인터페이스 이고

형태는 아래와 같다.

```java
@FunctionalInterface
public interface Comparable<T> {
    public abstract int compareTo(T t);
}
```