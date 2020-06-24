package stream_16.kind.get_stream_of_collection;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * 16.2.1 컬렉션으로부터 스트림 얻기
 */

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

        // forEach : void forEach(Consumer<? super T> action)
        // forEach는 매개변수로 Consumer 함수적 인터페이스를 필요로 한다.

//        // 람다식없이 forEach 실행
//        stream.forEach(new Consumer<Student>() {
//            @Override
//            public void accept(Student student) {
//                System.out.println(student.getName());
//            }
//        });
        // 스트림은 재활용 할 수 없다 (IllegalStateException)
    }
}
