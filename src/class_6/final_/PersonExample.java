package class_6.final_;

public class PersonExample {
    public static void main(String[] args) {
        Person p1 = new Person("123456-1111111", "hun");

        System.out.println(p1.nation);
        System.out.println(p1.ssn);
        System.out.println(p1.name);

        // p1.nation = "USA";  // final 변수는 수정 불가능
        // p1.ssn = "654321-1111111";  // final 변수는 수정 불가능
        p1.name = "kim";    // 수정 가능
    }
}
