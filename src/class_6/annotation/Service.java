package class_6.annotation;

// Annotation 을 적용한 클래스
public class Service {

    // @PrintAnnotation     // Target에 field가 없기때문에 field위에 정의하면 안된다.
    int field1 = 5;

    @PrintAnnotation        // element 의 기본값을 사용, @를 이용해서 내가 정의한 Target 위에 Annoataion을 넣는다.
    public void method_name1() {
        System.out.println("실행 내용1");
    }

    @PrintAnnotation("*")   // value 의 값이 "-"가 아닌, "*"가 된다.
    public void method_name2() {
        System.out.println("실행 내용2");
    }

    @PrintAnnotation(value="#", number=20)  // 두 개 이상일 경우 구분자로 구분해 주어야 한다.
    public void method_name3() {
        System.out.println("실행 내용3");
    }

    public void method4_name() {
        System.out.println("실행 내용4");
    }
}
