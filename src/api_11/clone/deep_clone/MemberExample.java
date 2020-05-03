package api_11.clone.deep_clone;

public class MemberExample {
    public static void main(String[] args) {
        // 원본 객체 생성
        Member original = new Member("홍길동", 25, new int[] {90, 95}, new Car("소나타"));

        // 복제 객체를 얻은 후에 참조 객체의 값을 변경
        Member cloned = original.getMember();
        cloned.scores[0] = 100;
        cloned.car.model = "그랜저";
        // 깊은 복제 후 참조 객체의 데이터를 변경

        System.out.println("[복제 객체의 필드값");
        System.out.println("name : " + cloned.name);
        System.out.println("age : " + cloned.age);
        System.out.println("scores : " + cloned.arrayToString());
        System.out.println("car : " + cloned.car.model);

        System.out.println();

        System.out.println("[원본 객체의 필드값]");
        System.out.println("name : " + original.name);
        System.out.println("age : " + original.age);
        System.out.println("scores : " + original.arrayToString());
        System.out.println("car : " + original.car.model);
    }
}
