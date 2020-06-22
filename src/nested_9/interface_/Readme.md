### 중첩 인터페이스

`중첩 인터페이스` : 클래스의 멤버로 선언된 인터페이스

```java
class A {
    // I : 중첩 인터페이스
    interface I {
        public abstract void method();
    }
}
```

중첩 인터페이스는 UI 프로그래밍에서 이벤트를 처리할 목적으로 주로 사용된다.

- 파일 리스트

| 파일 이름       | 설명                                              |
| --------------- | ------------------------------------------------- |
| Button          | 중첩 인터페이스가 선언된 클래스                   |
| CallListener    | Button의 중첩 인터페이스를 구현한 구현 클래스1    |
| MessageListener | Button의 중첩 인터페이스를 구현한 구현 클래스2    |
| ButtonExample   | Button의 중첩 인터페이스를 사용하는 클래스 (main) |
