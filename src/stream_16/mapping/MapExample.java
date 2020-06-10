package stream_16.mapping;

import java.util.Arrays;
import java.util.List;

// 필터 mapXXX() 메소드

// mapXXX() 메소드는 요소를 대체하는 요소로 구성된 새로운 스트림을 리턴한다.
// 스트림에 A, B가 있을 경우 A는 C로 / B는 D로 대체된 스트림을 리턴한다.

public class MapExample {
    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(
                new Student("홍길동", 10),
                new Student("신용권", 20),
                new Student("유미선", 30)
        );

        studentList.stream()
                .mapToInt(Student::getScore)
                .forEach(System.out::println);

        // mapToInt : 학생 스트림을 점수들의 스트림으로 대체한다.
    }
}
