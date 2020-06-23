#### 생성자 참조

아래와 같은 코드를 생성자 참조로 간략히 줄이 수 있다.

`(a, b) -> { return new 클래스(a, b); }`

이를 아래와 같이 줄일 수 있다.

`클래스 :: new`

> 예시

```java
// 해당 코드를
Function<String, Member> function1 = (string) -> new Member(string);

// 아래와 같이 작성할 수 있다.
function1 = Member::new;   // 생성자 참조
Member member1 = function1.apply("angel");      // 매개값이 1개인 생성자 참조
```
