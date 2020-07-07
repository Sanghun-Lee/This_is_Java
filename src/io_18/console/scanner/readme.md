#### Scanner 클래스

Console 클래스는 문자열은 읽을 순 있지만, `기본 타입(int, double) 값`을 바로 읽을 순 없다.

그래서 `Scanner`클래스를 이용하면 기본 타입 값을 바로 읽을 수 있다.

Scanner 객체를 생성하려면 아래와 같이 작성하면 된다.

```java
Scanner scanner = new Scanner(System.in);
```

기본 타입의 값을 읽기 위해서

- nextBoolean
- nextByte
- nextShort
- nextInt
- nextLine
- nextDouble

등을 지원한다.