### 16.8 매칭 allMatch(), anyMatch(), noneMatch()

매칭은 최종 처리 단계에서 요소들이 특정 조건에 만족하는지 조사할 수 있도록 제공하는 매칭 메소드 이다.

> allMatch()

메소드 타입은 아래와 같다.

`boolean allMatch(Predicate<T> predicate)`

`boolean allMatch( (Int/Long/Double)Predicate predicate)`

모든 요소들이 매개값으로 주어진 Predicate의 조건을 만족하는지 조사하고 `true / false`를 리턴한다.

> anyMatch()

메소드 타입은 `allMatch`에서 메소드 이름만 anyMatch로 바꾼것과 같다.

최소 한 개의 요소가 매개값으로 주어진 Predicate의 조건을 만족하는지 조사하고,

`true / false`를 리턴한다.

> noneMatch()

모든 요소들이 매개값으로 주어진 Predicate의 조건을 만족하지 않는지 조사한다.

모두 Predicate의 조건을 만족하지 않으면 `true`를 리턴하고, 하나라도 만족하면 `false`를 리턴한다.