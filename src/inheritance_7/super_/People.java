package inheritance_7.super_;

public class People {
    public String ssn;
    public String name;

    // 부모 생성사 생성
    public People(String name, String ssn) {
        this.name = name;
        this.ssn = ssn;
    }

    public void function() {
        System.out.println("People의 function");
    }
}
