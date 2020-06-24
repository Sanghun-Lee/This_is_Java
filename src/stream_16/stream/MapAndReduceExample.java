package stream_16.stream;

import java.util.Arrays;
import java.util.List;

/**
 * 스트림의 특징3
 * 스트림은 중간 처리와 최종 처리를 할 수 있다.
 *
 * 중간 처리는 filtering, mapping, sorting, looping
 * 최종 처리는 matching, collect, looping, aggregate
 * 에서 살펴볼 수 있다.
 */

public class MapAndReduceExample {
    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(
                new Student("홍길동", 10),
                new Student("신용권", 20),
                new Student("유미선", 34)
        );

        double avg = studentList.stream()
                // 중간처리 (학생 객체를 점수로 매핑)
                .mapToInt(Student::getScore)
                // 최종처리 (평균점수)
                .average()
                .getAsDouble();

        // mapToInt : student를 받아서 student의 getScore를 호출해서 int값만 빼내도록 한다.
        // 메소드 참조로 s->getScore() ->> Student::getScore
        // average : mapToInt로 중간처리된 값을 평균을 낸다. (최종처리)
        // average 나온 값을 double로 바꾼다.
        double average = studentList.stream().mapToInt(s -> s.getScore()).average().getAsDouble();

        // studentList.stream : student 객체를 요소로 가지는 Stream
        // mapToInt 가 리턴하는 stream : student 를 점수로 매핑한, 즉 점수가 요소인 stream을 얻어낸다.
        // average : mapToInt가 리턴한 stream에서 값들의 평균을 계산한다.
        // average 가 리턴하는 값이 OptionalDouble 이라서 getAsDouble로 double 자료형으로 리턴받는다.

        System.out.println("평균 점수 : " + avg);
    }
}
