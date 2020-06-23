#### and, or, negate 디폴트 메소드, isEqual 정적 메소드

Predicate는 and, or, negate 연산을 지원한다

각각은 논리 연산자인 &&, ||, !과 대응된다.

> and()의 사용

`predicateAB = predicateA.and(predicateB)`

predicateAB를 `predicateAB.test(x)`로 호출하면

`predicateA.test(x)`가 <strong>true</strong> 이고, `predicateB.test(x)`가 <strong>true</strong> 일 때만 predicateAB가 true가 된다.

or, negate 모두 동일하다.

> isEqual의 사용

isEqual은 다음과 같은 리턴값을 제공한다.

| sourceObject | targetObject | 리턴 값                                     |
| ------------ | ------------ | ------------------------------------------- |
| null         | null         | true                                        |
| not null     | null         | false                                       |
| null         | not null     | false                                       |
| not null     | not null     | sourceObject.equals(targetObject)의 리턴 값 |

사용 예시

```
// 정적 메소드라서 Predicate.isEqual을 사용해야 한다.
Predicate<Object> predicate = Predicate.isEqual(tagetObject);
boolean result = predicate.test(sourceObject);
```
