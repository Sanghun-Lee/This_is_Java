#### 9.5.1 익명 자식 객체 생성

일반적으로 부모 타입으로 필드나 변수를 선언하고, 자식 객체를 초기값으로 대입할 경우

부모 클래스를 상속해서 자식 클래스를 선언하고, new 연산자로 호출해야 한다.

`Parent field = new Child();`

하지만 해당 Child가 재사용 되지 않는다면, `익명 자식 객체`를 생성하는 것이 좋다.

그래서 익명 자식 객체를 생성하는 방법은 아래와 같다.

```java
Parent field = new Parent() {
    int childField1;
    void childMethod() { ... }
    @Override
    void parentMethod() { ... }
};
```

로컬 변수와 함수의 매개변수로 익명 자식 객체를 받는 방법도 위와 동일하다.

| 파일 이름        | 설명                                           |
| ---------------- | ---------------------------------------------- |
| Anonymous        | 익명 자식 객체를 생성하는 클래스               |
| AnonymousExample | Anonymous 클래스를 생성하는 메인 메소드 (main) |
| Person           | 부모 클래스                                    |
