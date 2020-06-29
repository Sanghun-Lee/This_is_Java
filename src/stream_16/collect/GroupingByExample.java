package stream_16.collect;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingByExample {
    public static void main(String[] args) {
        List<Student> totalList = Arrays.asList(
                new Student("홍길동", 10, Student.Sex.MALE),
                new Student("김수애", 6, Student.Sex.FEMALE),
                new Student("신용권", 10, Student.Sex.MALE),
                new Student("박수미", 6, Student.Sex.FEMALE)
        );

        // groupingBy(key mapper), Function interface를 필요로 한다.
        Map<Student.Sex, List<Student>> mapBySex = totalList.stream()
                .collect(Collectors.groupingBy(s -> s.getSex()));

        // 잘 그룹핑이 되었는지 확인
        System.out.println("[남학생]");
        mapBySex.get(Student.Sex.MALE).stream()
                .forEach(s -> System.out.print(s.getName() + " "));

        System.out.println("\n[여학생]");
        mapBySex.get(Student.Sex.FEMALE).stream()
                .forEach(s -> System.out.print(s.getName() + " "));

        System.out.println();

        // 주소를 기준으로 mapping 하는데, 이름만 저장해 보자.
        Map<Student.City, List<String>> mapByCity = totalList.stream()
                .collect(Collectors.groupingBy(new Function<Student, Student.City> () {
                    @Override
                    public Student.City apply(Student s) {
                        return s.getCity();
                    }
                }, Collectors.mapping(new Function<Student, String> () {
                    @Override
                    public String apply(Student s) {
                        return s.getName();
                    }
                }, Collectors.toList())));

        // groupingBy 메소드의 매개변수는 (Function keyMapper, Collector<T, A, D> collector) 를 필요로 하는데
        // Collectors.mapping 메소드는 (Function mappingValue, Collector<T, A, D> collector) 를 매개변수로 받아서
        // Function 인터페이스가 리턴하는 값을 collector의 컬렉션으로 만들어서 Collector<T, A, D> output_collector를 리턴한다.

        // 그래서 위의 예제는 Student의 이름을 값으로 한 List Collector를 리턴한다.
        // Collector<Student, ?, List<String>> Collectors.mapping(Function<Student, String>, Collector<String, ?, List<String>>)
        // 형태가 된다.

        // ----
        // 마지막으론 Map이 아닌, TreeMap 객체를 생성하도록 groupingBy를 사용해 보자.
        Map<Student.City, List<String>> treeMapByCity = totalList.stream()
                .collect(Collectors.groupingBy(Student::getCity, TreeMap::new, Collectors.mapping(Student::getName, Collectors.toList())));
    }
}
