package collection_framework_15.list.array_list;

import java.util.Arrays;
import java.util.List;

public class ArraysAsListExample {
    public static void main(String[] args) {
        // Arrays.asList() 메소드로 ArrayList 객체를 생성할 수 있다.
        List<String> list1 = Arrays.asList("홍길동", "신용권", "김자바");
        for(String name : list1) {
            System.out.println(name);
        }

        List<Integer> list2 = Arrays.asList(1, 2, 3);
        for(int value : list2) {
            System.out.println(value);
        }
    }
}
