package stream_16.collect;

/**
 * 필터링으로 새로운 컬렉션 생성
 * 최종처리된 후, 해당 요소들을 컬렉션(List, Set, Map...) 형태로 만들기 위해서 collect() 메소드를 이용한다.
 *
 * collect() 메소드의 매개변수는 Collector<T, A, R> 클래스의 객체를 필요로 하는데,
 * 해당 객체는 아래 정적 메소드를 이용해서 얻을 수 있다.
 *
 * Collector.toList() -> Collector<T, ?, List<T>> 객체를 리턴한다.
 * .toSet(), .toMap() 도 위와 같이 리턴한다.
 *
 * HashMap이나, LinkedList와 같은 컬렉션을 사용하고 싶으면 .toCollection() 메소드를 사용하면 된다.
 * Collector.toCollection(Supplier<Collection<T>>) 와 같은 형태이고, Supplier에 내가 원하는 컬렉션을 생성하면 된다.
 */

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToListExample {
    public static void main(String[] args) {
        List<Student> totalList = Arrays.asList(
                new Student("홍길동", 10, Student.Sex.MALE),
                new Student("김수애", 6, Student.Sex.FEMALE),
                new Student("신용권", 10, Student.Sex.MALE),
                new Student("박수미", 6, Student.Sex.FEMALE)
        );

        // 남학생들만 묶어 List 생성
        List<Student> maleList = totalList.stream()
                .filter(m -> m.getSex() == Student.Sex.MALE)
                .collect(Collectors.toList());

        // 위 코드와 아래 코드가 동일한 역할을 한다.
        Stream<Student> totalStream = totalList.stream();
        Stream<Student> maleStream = totalStream.filter(s -> s.getSex() == Student.Sex.MALE);
        Collector<Student, ?, List<Student>> collector = Collectors.toList();
        maleList = maleStream.collect(collector);

        maleList.forEach(s -> System.out.println(s.getName()));
        System.out.println();

        // 여학생들만 묶어 HashSet 생성
        Set<Student> femaleSet = totalList.stream()
                .filter(s -> s.getSex() == Student.Sex.FEMALE)
                .collect(Collectors.toCollection(HashSet::new));    // 생성자 참조

        femaleSet = totalList.stream()
                .filter(s -> s.getSex() == Student.Sex.FEMALE)
                .collect(Collectors.toCollection(() -> new HashSet<>()));
        // Collection 안에는 Supplier 인터페이스가 있다.

        // 람다식을 사용하지 않으면 아래와 같다.
        femaleSet = totalList.stream()
                .filter(new Predicate<Student>() {
                    @Override
                    public boolean test(Student s) {
                        return s.getSex() == Student.Sex.FEMALE;
                    }
                })
                .collect(Collectors.toCollection(new Supplier<HashSet<Student>>() {
                    @Override
                    public HashSet<Student> get() {
                        return new HashSet<Student>();
                    }
                }));

        femaleSet.forEach(s -> System.out.println(s.getName()));


        // Collectors.toMap 메소드 사용해 보기
        // Key는 이름, Value는 Student 객체로 만들어 보기
        Map<String, Student> studentMap = totalList.stream().collect(Collectors.toMap(Student::getName, Function.identity()));

        // 위와 같은 의미이다.
        studentMap = totalList.stream().collect(Collectors.toMap(s -> s.getName(), s -> s));

        // 이를 람다식 없이 구현해 보면
        studentMap = totalList.stream().collect(
                Collectors.toMap(new Function<Student, String> () {
                    @Override
                    public String apply(Student s) {
                        return s.getName();
                    }
                }, new Function<Student, Student> () {
                    @Override
                    public Student apply(Student s) {
                        return s;
                    }
                }));

        System.out.println("studentMap - 박수미의 점수 : " + studentMap.get("박수미").getScore());
    }
}
