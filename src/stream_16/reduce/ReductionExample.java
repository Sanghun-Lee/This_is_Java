package stream_16.reduce;

import stream_16.sorting.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class ReductionExample {
    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(
                new Student("홍길동", 30),
                new Student("신용권", 20),
                new Student("유미선", 45)
        );

        // sum을 이용해서 합계 얻기
        int sum1 = studentList.stream()
                .mapToInt(Student::getScore)
                .sum();

        // 커스텀 집계로 합계 얻기
        int sum2 = studentList.stream()
                .map(Student::getScore)
                .reduce((a, b) -> a + b)
                .get();

        int sum3 = studentList.stream()
                .map(Student::getScore)
                .reduce(0, (a, b) -> a + b);

        System.out.println("sum1 : " + sum1);
        System.out.println("sum2 : " + sum2);
        System.out.println("sum3 : " + sum3);

        // 람다식이 아닌, 익명 구현 객체로 합계 얻기

        sum2 = studentList.stream()
                .map(new Function<Student, Integer>() {
                    @Override
                    public Integer apply(Student s) {
                        return s.getScore();
                    }
                })
                .reduce(new BinaryOperator<Integer>() {
                    @Override
                    public Integer apply(Integer a, Integer b) {
                        return a + b;
                    }
                })
                .get();
        // 왜 "getAsInt"가 아니지? >> 최종 객체가 Optional 타입이라서 그렇다.
        // OptionalDouble 일 때 getAsDouble 메소드를 호출한다.
    }
}
