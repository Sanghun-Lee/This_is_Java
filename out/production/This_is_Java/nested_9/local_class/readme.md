### 로컬 클래스에서 사용 제한

로컬 클래스의 경우 `클래스는 힙에` 데이터가 들어가고,

클래스를 선언한 메소드의 `매게변수, 지역변수는 스택에 들어간다.`

그래서 메소드의 호출이 끝나게 되면 `매게변수와 지역변수는 사라지지만,` 클래스는 힙에 남아 있어서

<strong>클래스에서 이미 소멸된 메소드의 매개변수, 지역변수를 접근할 수 있다.</strong>

그래서 메소드의 매개변수와 지역변수가 로컬 클래스에서 사용되면 무조건 `상수화`된다.

```java
void outMethod(final int arg1, int arg2) {
    final int var1 = 1;
    int var2 = 2;
    class LocalClass {
        void method() {
            int result = arg1 + arg2 + var1 + var2;
        }
    }
}
```

위와 같은 예제에서 `arg2`와 `var2`모두 final 특성을 갖게 된다.
