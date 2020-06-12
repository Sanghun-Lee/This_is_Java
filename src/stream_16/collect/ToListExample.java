package stream_16.collect;

// 필터링해서 새로운 컬렉션 생성

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
                .collect(Collectors.toCollection(HashSet::new));

        femaleSet.forEach(s -> System.out.println(s.getName()));
    }
}