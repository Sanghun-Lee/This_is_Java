### 14.5.6 디폴트 메소드

디폴트 메소드와 정적 메소드는 함수적 인터페이스에 추가하여도 문제가 없기 때문에

- Consumer, Function, Operator의 함수적 인터페이스에는
  - andThen()
  - compose()

이 두 개의 디폴트 메소드를 제공한다.

- Predicate 함수적 인터페이스는
  - and()
  - or()
  - negate()
  - isEqual()

and, or, negate 디폴트 메소드와 isEqual 정적 메소드를 제공한다.

| 챕터   | 패키지          | 설명                                          |
| ------ | --------------- | --------------------------------------------- |
| 14.5.6 | andThen_compose | andThen()과 compose() 디폴트 메소드           |
| 14.5.7 | predicate       | and, or, negate, isEqual (디폴트/정적) 메소드 |
