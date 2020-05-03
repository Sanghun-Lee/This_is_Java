package api_11.object_class.hashCode;

import java.util.Objects;

// 해시코드 생성(hash(), hashCode())
// Objects.hash(Object ... values) 메소드는 매개값으로 주어진 값들을 이용해서 해시코드를 생성하는 역할을 한다.
// 해당 메소드는 주어진 매개값으로 배열을 생성해서 Arrays.hashCode(Object[]) 를 호출해서 해시코드값을 얻고, 이 값을 다시 리턴한다.
// Objects.hash() 메소드는 클래스가 hashCode() 메소드를 Override 할 때 리턴값을 생성하기 위해 사용하면 좋다.
// 클래스가 여러 가지 필드를 가지고 있을 때 이 필드들로부터 해시코드를 생성하게되면 동일한 필드값을 가지는 객체는 동일한 해시코드를 가질 수 있다.

public class HashCodeExample {
    public static void main(String[] args) {
        Student s1 = new Student(1, "홍길동");
        Student s2 = new Student(1, "홍길동");
        System.out.println(s1.hashCode());
        System.out.println(Objects.hashCode(s2));
    }

    static class Student {
        int sno;
        String name;
        Student(int sno, String name) {
            this.sno = sno;
            this.name = name;
        }

        // hashCode 를 Override 했다.
        // 객체의 field 를 이용해서 hashCode 를 생성한다.
        @Override
        public int hashCode() {
            return Objects.hash(sno, name);
        }
    }
}
