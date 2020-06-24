package stream_16.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * 스트림의 특징1
 * 람다식으로 요소 처리 코드를 제공한다.
 */

public class LambdaExpressionsExample {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("홍길동", 90),
                new Student("신용권", 92)
        );

        // 학생 객체를 기준으로 스트림을 얻는다. list.stream();
        Stream<Student> studentStream = list.stream();
        studentStream.forEach(s -> {
            String name = s.getName();
            int score = s.getScore();
            System.out.println(name + " - " + score);
        });

        // 람다식 없이 익명 구현 객체를 이용하면 아래와 같다.
        studentStream.forEach(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                String name = student.getName();
                int score = student.getScore();
                System.out.println(name + " - " + score);
            }
        });
    }
}
