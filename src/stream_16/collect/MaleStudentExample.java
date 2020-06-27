package stream_16.collect;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 사용자 정의 컨테이너에 수집하기
 * 사용자 정의 컨테이너 : 개발자가 작성한 class (MaleStudent)
 * collect 메소드를 이용해서 만들 수 있고
 * collect(객체 생성 (supplier), 객체 추가 (biConsumer), 객체 결합 (biConsumer))
 */

public class MaleStudentExample {
    public static void main(String[] args) {
        List<Student> totalList = Arrays.asList(
                new Student("홍길동", 10, Student.Sex.MALE),
                new Student("김수애", 6, Student.Sex.FEMALE),
                new Student("신용권", 10, Student.Sex.MALE),
                new Student("박수미", 6, Student.Sex.FEMALE)
        );

        // 남학생만 별도로 필터링 해서 MaleStudent에 수집 해보자.
        MaleStudent maleStudent = totalList.stream()
                .filter(s -> s.getSex() == Student.Sex.MALE)
                .collect(
                        () -> new MaleStudent(),    // supplier 선언
                        (r, t) -> r.accumulate(t),  // biConsumer 선언, r : MaleStudent, t : Student 요소
                        (r1, r2) -> r1.combine(r2)  // biConsumer r1에 r2값을 추가한다.
                );
        // 컨테이너를 생성하는 Supplier 선언 / 객체를 추가하는 BiConsumer 선언 / 두 컨테이너를 결합하는 BiConsumer 선언
        // 필터링한 요소가 2개이기 때문에 accumulate 메소드가 두 번 호출된다.

        maleStudent.getList().stream().forEach(s -> System.out.println(s.getName()));

        // 위 식을 익명 구현 객체를 이용해서 만들어 보자.
        maleStudent = totalList.stream()
                .filter(new Predicate<Student>() {
                    @Override
                    public boolean test(Student s) {
                        return s.getSex() == Student.Sex.MALE;
                    }
                })
                .collect(new Supplier<MaleStudent>() {
                    @Override
                    public MaleStudent get() {
                        return new MaleStudent();
                    }
                }, new BiConsumer<MaleStudent, Student>() {
                    @Override
                    public void accept(MaleStudent m, Student s) {
                        m.accumulate(s);
                    }
                }, new BiConsumer<MaleStudent, MaleStudent>() {
                    @Override
                    public void accept(MaleStudent m1, MaleStudent m2) {
                        m1.combine(m2);
                    }
                });

        maleStudent.getList().stream().forEach(new Consumer<Student>() {
            @Override
            public void accept(Student s) {
                System.out.println(s.getName());
            }
        });
    }
}
