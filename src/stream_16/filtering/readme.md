### 필터링

중간처리 방법 중 하나

중복을 구분하는 distinct() 와

특정 요소를 가리는 filter() 메소드가 있다.

> distinct()

distinct는 중복을 제거하는 스트림이고, `Object.equals(Object)`가 true이면 동일한 객체로 판단하고

중복을 제거한다.

`int`, `long`, `double`과 같은 기본 타입의 변수일 경우 동일값일 경우 중복을 제거한다.

> filter()

filter의 경우 매개변수로 `Predicate`인터페이스를 필요로 한다.

그래서 해당 `Predicate`값이 true인 것만 가지고 새로운 스트림을 생성한다.