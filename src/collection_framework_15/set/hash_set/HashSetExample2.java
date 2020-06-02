package collection_framework_15.set.hash_set;

// Member 객체를 중복없이 저장하는 HashSet

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample2 {
    public static void main(String[] args) {
        Set<Member> set = new HashSet<>();

        set.add(new Member("홍길동", 30));
        set.add(new Member("홍길동", 30));

        System.out.println("총 객체 수 : " + set.size());
    }
}
