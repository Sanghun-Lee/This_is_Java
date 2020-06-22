### 익명 구현 객체 생성

child 파일에서는 익명의 자식 객체를 생성해 보았다.

즉, 자식 클래스가 해당 클래스에서만 사용하게 될 경우 `익명 자식 객체`로 만드는것이 더 좋은 방법이었다.

이번에는 인터페이스의 구현 객체를 특정 클래스에 대입하려면 아래와 같이 사용되어야 한다.

```java
class TV implements RemoteControl { /* ... */ }   // 인터페이스 구현 클래스

class A {
    RemoteControl rc = new TV();
    void method() {
        RemoteControl rc = new TV();
    }
}
```

하지만 구현 클래스 (TV)가 재사용 되지 않고, 오로지 해당 필드와 변수의 초기값으로만 사용되는 경우라면

익명 구현 객체를 초기값으로 대입하는 것이 좋다.

아래와 같이 사용될 수 있다.

```java
RemoteControl rc = new RemoteControl() {
    // 추상메소드 Override
    // other field
    // other method
};
```

| 파일 이름        | 설명                                           |
| ---------------- | ---------------------------------------------- |
| Anonymous        | 익명 구현 객체를 생성하는 클래스               |
| AnonymousExample | Anonymous 클래스를 생성하는 메인 메소드 (main) |
| RemoteControl    | 인터페이스                                     |
