#### Predicate 함수적 인터페이스

Predicate 함수적 인터페이스는 매개변수와 boolean 리턴값이 있는 testXXX() 메소드를 가지고 있다.

매개 변수 타입과 수에 따라서 아래와 같은 Predicate 함수적 인터페이스들이 있다.

| 인터페이스명      | 추상 메소드                | 설명                   |
| ----------------- | -------------------------- | ---------------------- |
| Predicate\<T>     | boolean test(T t)          | 객체 T를 조사          |
| BiPredicate<T, U> | boolean test(T t, U u)     | 객체 T와 U를 비교 조사 |
| DoublePredicate   | boolean test(double value) | double 값을 조사       |
| IntPredicate      | boolean test(int value)    | int 값을 조사          |
| LongPredicate     | boolean test(long value)   | long 값을 조사         |

Predicate의 사용 예시

`Predicate<Student> predicate = t -> { return t.getSex().equals("남자"); }`

해당 파일의 예제는 List에 저장된 남자 또는 여자 학생들의 평균 점수를 출력한다.
