package api_11.clone.thin_clone;

public class MemberExample {
    public static void main(String[] args) {
        // 원본 객체 생성
        Member original = new Member("blue", "홍길동", "12345", 25, true);

        original.array = new int[] {1, 2, 3, 4, 5}; // 배열객체에 임의의 값 대입


        // 복제 객체를 얻은 후에 패스워드 변경
        Member cloned = original.getMember();
        cloned.password = "67890";      // 복제 객체에서 패드워스 변경
        // 새로운 객체를 참조하도록 만들었다.

        cloned.array[4] = 9999;

        System.out.println("[복제 객체의 필드값]");
        System.out.println("id : " + cloned.id);
        System.out.println("name : " + cloned.name);
        System.out.println("password : " + cloned.password);
        System.out.println("age : " + cloned.age);
        System.out.println("adult : " + cloned.adult);
        System.out.println("array : " + cloned.arrayToString());

        System.out.println();

        System.out.println("[원본 객체의 필드값]");
        System.out.println("id : " + original.id);
        System.out.println("name : " + original.name);
        System.out.println("password : " + original.password);      // 원본 객체는 변함이 없다.
        System.out.println("age : " + original.age);
        System.out.println("adult : " + original.adult);
        System.out.println("array : " + original.arrayToString());
    }
}
