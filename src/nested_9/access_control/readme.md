### 중첩 클래스의 접근 제한

바깥 클래스(A)에서 멤버 클래스(B, C)의 인스턴스(객체)를 생성할 때 어느정도 제약이 따른다.

인스턴스 멤버 클래스(B)의 경우 static class 가 아니기 때문에, static field, static method 내부에 B 객체를 생성하는 것은 에러를 일으킨다.

static 멤버 클래스(C)의 경우 static class 이기 때문에, 아무런 제약을 받지 않는다.

멤버 클래스(B, C)에서 바깥 클래스(A)의 필드와 메소드를 접근할 때에도 제약이 따른다.

인스턴스 멤버 클래스(B)의 경우 모두 접근 가능하다.

static 멤버 클래스(C)의 경우 static 변수, static method 만 접근 가능하다.

너무 당연한 소리다.

B는 A가 생성되어야지만 생성할 수 있기 때문에, A 생성 전에 사용할 수 있는 static 변수와 메소드를 못쓴는 것은 당연하다.

그리고 C는 정적 멤버 클래스이기 때문에 A가 생성하고 접근 가능한 것들 (필드, 메소드)을 접근 못하는 것은 너무 당연하다.

#### 인스턴스 멤버 클래스의 접근 제한

```java
class A {
    int instance_field;
    void instance_method() { ... }

    static int static_field;
    static void static_method() { ... }

    // instance member class B
    class B {
        void method() {
            instance_field = 10;    // (o)
            instance_method();      // (o)

            static_field = 10;      // (o)
            static_method();        // (o)
        }
    }
}
```

#### 정적 멤버 클래스의 접근 제한

```java
class A {
    int instance_field;
        void instance_method() { ... }

        static int static_field;
        static void static_method() { ... }

        // static member class B
        static class B {
            void method() {
                // A의 객체가 없기 때문에 불가능하다.
                // instance_field = 10;    // (x)
                // instance_method();      // (x)

                static_field = 10;      // (o)
                static_method();        // (o)
            }
        }
}
```
