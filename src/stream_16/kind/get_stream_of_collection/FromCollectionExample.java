package stream_16.kind.get_stream_of_collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FromCollectionExample {
    public static void main(String[] args) {
        // List Collection 생성
        List<Student> studentList = Arrays.asList(
            new Student("홍길동", 10),
            new Student("신용권", 32),
            new Student("유미선", 33)
        );

        // stream 메소드로 Collection의 stream 객체를 얻을 수 있다.
        Stream<Student> stream = studentList.stream();
        // 's' 에는 student 객체가 하나씩 대입되고, 이를 람다식을 이용해서 처리한다.
        // List에 있는 Student 객체가 하나씩 s 에 대입되고, 람다식을 이용해서 이를 처리한다.
        stream.forEach(s->System.out.println(s.getName()));
        stream.forEach(Student::getName);

        // forEach : void forEach(Consumer<? super T> action)
    }
}
