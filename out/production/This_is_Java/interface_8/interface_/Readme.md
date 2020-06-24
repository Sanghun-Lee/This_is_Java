## 인터페이스의 사용

인터페이스는 `필드`, `생성자`, `메소드`, `로컬 변수`, `매개변수` 들에 사용될 수 있다.

> 예시

```java
public class MyClass {
// 필드
RemoteControl rc = new Television();

// 생성자  
MyClass(RemoteControl rc) {
    this.rc = rc;
}

// 메소드
void methodA() {
    // 로컬 변수
    RemoteControl rc = new Audio();
}

// 매개변수
void methodB(RemoteControl rc) { /* ... */ } 

}
```

이 중에서 <strong>생성자와 매개변수</strong> 부분을 중요하게 봐야 한다.

생성자와 매개변수로 오는 경우 <strong>해당 인터페이스를 구현한 클래스면 모두 올 수 있기 때문이다.</strong>

