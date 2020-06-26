### 컬렉션으로부터 스트림 얻기

1. List Collection 생성

```java
List<Student> studentList = Arrays.asList(
        new Student("홍길동", 10),
        new Student("신용권", 32),
        new Student("유미선", 33)
);
```

2. stream() 메소드로 스트림 생성

```java
Stream<Student> stream = studentList.stream();
```

이제 forEach와 같은 stream 메소드를 사용하면 된다.