package lambda_expression_14.api.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class FunctionExample1 {
    private static List<Student> list = Arrays.asList(
            new Student("홍길동", 90, 96),
            new Student("신용권", 95, 93)
    );

    // Function<T, R> 의 추상 메소드 : R apply(T t)
    public static void printString(Function<Student, String> function) {
        for(Student student : list) {   // list 에 저장된 항목 수 만큼 루핑
            System.out.println(function.apply(student) + " ");
        }
        System.out.println();
    }
    // 위 메소드는 list 만큼 돌면서 매개변수로 받은 function 의 구현 객체의 apply 메소드를 실행한다.
    // main 메소드에서 function 의 구현 객체를 t -> t.getName() 으로 주었기 때문에
    // function.apply 를 실행할 때 t의 값으로 student 를 전달하고, 그러면 student.getName 메소드가 실행되어서
    // student 객체의 이름이 리턴되어 print 된다.

    public static void printInt(ToIntFunction<Student> function) {
        for(Student student : list) {   // list 에 저장된 항목 수 만큼 루핑
            System.out.print(function.applyAsInt(student) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("[학생 이름]");
        printString(t -> t.getName());  // name 필드의 getter
        // (t) -> { return t.getName(); }
        // 매개변수로 t를 주고, 리턴값은 t.getName 메소드의 리턴값이다.

        System.out.println("[영어 점수]");
        printInt(t -> t.getEnglishScore());

        System.out.println("[수학 점수]");
        printInt(t -> t.getMathScore());
    }
}
