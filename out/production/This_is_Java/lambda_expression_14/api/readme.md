### Functional interface api

빈번하게 사용되는 함수적 인터페이스를 java 8부터 표준 API 로 제공한다.

이제부터 하나씩 살펴보자.

| API이름   | 파일 이름 | 추상 메소드 특징                   | 기타                                           |
| --------- | --------- | ---------------------------------- | ---------------------------------------------- |
| Consumer  | consumer  | 매개값은 있고, 리턴값이 없다.      | ...                                            |
| Supplier  | supplier  | 매개값은 없고, 리턴값이 있다.      | ...                                            |
| Function  | function  | 매개값도 있고, 리턴값도 있다.      | 매개값을 리턴값으로 매핑(타입변환)에 사용된다. |
| Operator  | operator  | 매개값도 있고, 리턴값도 있다.      | 매개값을 연산하고 결과를 리턴한다.             |
| Predicate | predicate | 매가값은 있고, 리턴 타입은 boolean | 매개값을 조사해서 True/False를 리턴한다.       |

> 파일 리스트

| 챕터   | 파일                     | 설명                                                        |
| ------ | ------------------------ | ----------------------------------------------------------- |
| 14.5.1 | consumer                 | Consumer 함수적 인터페이스                                  |
| 14.5.2 | supplier                 | Supplier 함수적 인터페이스                                  |
| 14.5.3 | function                 | Function 함수적 인터페이스                                  |
| 14.5.4 | operator                 | Operator 함수적 인터페이스                                  |
| 14.5.5 | predicate                | Predicate 함수적 인터페이스                                 |
| 14.5.6 | default_method           | andThen()과 compose() 디폴트 메소드                         |
| 14.5.7 | default_method.predicate | and(), or(), negate() 디폴트 메소드와 isEqual() 정적 메소드 |
| 14.5.8 | operator                 | minBy(), maxBy() 정적 메소드                                |
