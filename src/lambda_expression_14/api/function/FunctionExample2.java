package lambda_expression_14.api.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

public class FunctionExample2 {
    private static List<Student> list = Arrays.asList(
            new Student("홍길동", 88, 64),
            new Student("신용권", 91, 98)
    );

    public static double avg(ToIntFunction<Student> function) {
        int sum = 0;
        for(Student student : list) {
            sum += function.applyAsInt(student);    // 매개값으로 받은 람다식을 실행한다.
            // englishAvg 의 경우 student.getEnglishScore() 메소드가 실행되고,
            // mathAvg 의 경우 student.getMathScore() 메소드가 function.applyAsInt(student) 대신에(?) 호출된다.
        }
        double avg = (double) sum / list.size();
        return avg;
    }

    public static void main(String[] args) {
        double englishAvg = avg(s -> s.getEnglishScore());  // 람다식이 ToIntFunction<Student> 인스턴스로 대입된다.
        System.out.println("영어 평균 점수 : " + englishAvg);

        double mathAvg = avg(s -> s.getMathScore());
        System.out.println("수학 평균 점수 : " + mathAvg);
    }
}
