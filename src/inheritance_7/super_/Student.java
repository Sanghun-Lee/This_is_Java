package inheritance_7.super_;

public class Student extends People {
    public int studentNo;

    public Student(String name, String ssn, int studentNo) {
        super(name, ssn);   // 부모 생성자 호출
        // 부모가 기본생성자가 있으면 super 가 없어도 되지만, 기본생성자가 없으면 자식생성자는 super를 이용해서 꼭 부모 생성자를 호출해야 한다.
        this.studentNo = studentNo;
    }

    // People이 가지고있는 메서드 function 을 Override 했다.
    @Override
    public void function() {
        System.out.println("Student의 function");
    }

    // Override 된 메소드의 원래 부모 메소드를 호출하기 위해선 super 키워드를 사용하면 된다.
    public void function_call() {
        function();         // Student 의 function 메소드 호출
        super.function();   // People(부모)의 function 메소드 호출
    }
}
