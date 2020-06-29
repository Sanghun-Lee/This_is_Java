package stream_16.parallel;

import java.util.Arrays;
import java.util.List;

/**
 * 병렬 처리
 * parallelStream() 으로 Stream을 생성하면 백그라운드에서 자동으로 ForkJoin 프레임워크를 실행시킨다.
 *
 *
 */

public class MaleStudentExample {
    public static void main(String[] args) {
        List<Student> totalList = Arrays.asList(
                new Student("홍길동", 10, Student.Sex.MALE),
                new Student("김수애", 6, Student.Sex.FEMALE),
                new Student("신용권", 10, Student.Sex.MALE),
                new Student("박수미", 6, Student.Sex.FEMALE)
        );

        MaleStudent maleStudent = totalList.parallelStream()
                .filter(s -> s.getSex() == Student.Sex.MALE)
                .collect(MaleStudent::new, MaleStudent::accumulate, MaleStudent::combine);

        maleStudent.getList().stream()
                .forEach(s -> System.out.println(s.getName()));
    }
}

/**
 * 실행 결과
 * [ForkJoinPool.commonPool-worker-3] MaleStudent()
 * [ForkJoinPool.commonPool-worker-5] MaleStudent()
 * [main] MaleStudent()
 * [ForkJoinPool.commonPool-worker-7] MaleStudent()
 * [ForkJoinPool.commonPool-worker-7] accumulate()
 * [ForkJoinPool.commonPool-worker-7] combine()
 * [main] accumulate()
 * [main] combine()
 * [main] combine()
 * 홍길동
 * 신용권
 *
 * ---
 * main에서 한 번, ForkJoinPool에서 3번 생성자 호출이 일어났고
 * main에서 두 번, ForkJoinPool에서 1번의 combine 메소드 호출이 일어났다.
 */