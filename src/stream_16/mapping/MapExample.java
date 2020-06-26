package stream_16.mapping;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;

/**
 * 필터 mapXXX() 메소드
 *
 * mapXXX() 메소드는 요소를 대체하는 요소로 구성된 새로운 스트림을 리턴한다.
 * 스트림에 A, B가 있을 경우 A는 C로 / B는 D로 대체된 스트림을 리턴한다.
 */


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

        // 람다식 없이 익명 구현 객체를 이용하면 아래와 같다.
        studentList.stream()
                .mapToInt(new ToIntFunction<Student>() {
                    @Override
                    public int applyAsInt(Student student) {
                        return student.getScore();
                    }
                })
                .forEach(new IntConsumer() {
                    @Override
                    public void accept(int value) {
                        System.out.println(value);
                    }
                });
    }
}
