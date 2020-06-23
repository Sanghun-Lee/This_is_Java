package lambda_expression_14.method_reference.constructor;

public class Member {
    private String name;
    private String id;

    // 기본 생성자
    public Member() {
        System.out.println("Member() 실행");
    }

    // 매개 변수가 한개인 생성자
    public Member(String id) {
        System.out.println("Member(String id) 실행");
    }

    // 매개 변수가 두 개인 생성자
    public Member(String name, String id) {
        System.out.println("Member(String name, String id) 실행");
        this.name = name;
        this.id  = id;
    }

    public String getId() {
        return id;
    }
}
