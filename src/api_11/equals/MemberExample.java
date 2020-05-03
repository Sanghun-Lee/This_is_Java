package api_11.equals;

// equals
// 두 객체가 다른 객체를 가리키면 obj1, obj2 false 를 리턴한다.
// equals 를 Override 해서 equals 메소드를 재정의 할 수 있다.

public class MemberExample {
    public static void main(String[] args) {
        Member obj1 = new Member("blue");
        Member obj2 = new Member("blue");
        Member obj3 = new Member("red");

        if(obj1.equals(obj2)) {
            System.out.println("obj1과 obj2는 동일합니다.");
        } else {
            System.out.println("obj1과 obj2는 동일하지 않습니다.");
        }

        if(obj1.equals(obj3)) {
            System.out.println("obj1과 obj3는 동일합니다.");
        } else {
            System.out.println("obj1과 obj3는 동일하지 않습니다.");
        }
    }
}
