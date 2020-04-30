package inheritance_7.super_;

public class StudentExample {
    public static void main(String[] args) {
        Student student = new Student("hun", "123456-1111111", 1);
        System.out.println("name : " + student.name);
        System.out.println("ssn : " + student.ssn);
        System.out.println("studentNo : " + student.studentNo);

    }
}
