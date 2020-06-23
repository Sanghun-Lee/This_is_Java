#### andThen(), compose()

andThen과 compose 디폴트 메소드는 두 개의 함수적 인터페이스를 순차적으로 연결하고,

첫 번째 처리 결과를 두 번째 매개값을 제공해서 최종 결과값을 얻을 때 사용한다.

> andThen()

```
인터페이스AB = 인터페이스A.andThen(인터페이스B);
최종결과 = 인터페이스AB.method();
```

andThen() 메소드는 인터페이스A부터 처리하고, 결과를 인터페이스B의 매개값으로 제공한다.

그리고 인터페이스B는 제공받은 매개값을 가지고 처리한 후 최종 결과를 리턴한다.

> compose()

```
인터페이스AB = 인터페이스A.compose(인터페이스B);
최종결과 = 인터페이스AB.method();
```

compose() 메소드는 인터페이스B부터 처리하고, 그 결과를 인터페이스A의 매개값으로 제공한다.

그리고 인터페이스A는 제공받은 매가값을 가지고 처리한 후 최종 결과를 리턴한다.

| 파일                          | 설명                                                        |
| ----------------------------- | ----------------------------------------------------------- |
| Address                       | 클래스파일1                                                 |
| Member                        | 클래스파일2                                                 |
| ConsumerAndThenExample        | Comsumer의 andThen() 디폴트 메소드를 활용한 예시            |
| FunctionAndThenComposeExample | Function의 andThen(), Compose() 디폴트 메소드를 활용한 예시 |
