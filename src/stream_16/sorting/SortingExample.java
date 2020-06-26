package stream_16.sorting;

/**
 * Stream 중간처리의 정렬
 *
 * 객체 요소가 Comparable을 구현한 상태에서 기본 비교 방법으로 정렬하고 싶을 때
 * sorted()
 * sorted( (a, b) -> a.compareTo(b) )
 * sorted(Comparator.naturalOrder())
 *
 * 객체 요소가 Comparable을 구현하고 있지만, 정반대 방법으로 정렬하고 싶을 때
 * sorted( (a, b) -> b.compareTo(a) )
 * sorted( Comparator.reverseOrder())
 *
 * 객체 요소가 Comparable을 구현하고 있지 않을 때
 * sotred( (a, b) -> { ... } )
 * Comparator 는 함수적 인터페이스라서 람다식을 바로 작성할 수 있다.
 */


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class SortingExample {
    public static void main(String[] args) {
        // 숫자 요소일 경우
        IntStream intStream = Arrays.stream(new int[] { 5, 4, 3, 2, 1});
        intStream
                .sorted()   // 숫자를 오름차순으로 정렬
                .forEach(n -> System.out.print(n + ", "));
        System.out.println();

        // 객체 요소일 경우
        List<Student> studentList = Arrays.asList(
                new Student("홍길동", 30),
                new Student("신용권", 20),
                new Student("유미선", 45)
        );

        studentList.stream()
                .sorted()       // 정수를 기준으로 오름차순으로 Student 정렬
                .forEach(s -> System.out.print(s.getScore() + ", "));
        System.out.println();

        studentList.stream()
                .sorted(Comparator.reverseOrder())  // 정수를 기준으로 내림차순으로 Student 정렬
                .forEach(s -> System.out.print(s.getScore() + ", "));
    }
}
