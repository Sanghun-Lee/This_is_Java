package collection_framework_15.map.hash_map;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample2 {
    public static void main(String[] args) {
        Map<Student, Integer> map = new HashMap<>();

        map.put(new Student("홍길동", 1), 95);
        map.put(new Student("홍길동", 1), 90);

        System.out.println("총 Entry 수 : " + map.size());
    }
}
