### 16.10 커스텀 집계 (reduce())

기본 집계 메소드인 sum, average, count, max, min 뿐만 아니라,

다양한 집계 결과물을 만들 수 있도록 reduce() 메소드도 제공한다.

reduce 메소드의 기본 타입

```
Optional<T> reduce(BinaryOperator<T> accumulator)
T reduce(T identity, BinaryOperator<T> accumulator)
```

제네릭 타입인 T 말고도 기본 타입인 int, long, double또한 지원한다.

`BinaryOperator` : 두 개의 매개값을 받아서 연산 후 결과 return 한다.

스트림에 요소가 없을 경우 디폴트 값인 identity 매개값이 리턴된다.