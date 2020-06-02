package collection_framework_15.set.hash_set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Java");
        set.add("JDBC");
        set.add("Servlet/JSP");
        set.add("Java");    // "Java"는 한 번만 저장된다.
        set.add("iBATIS");

        int size = set.size();
        System.out.println("총 객체 수 : " + size);

        Iterator<String> iterator = set.iterator(); // 반복자 얻기
        while(iterator.hasNext()) {
            String element = iterator.next();
            System.out.println("\t" + element);
        }

        set.remove("JDBC");
        set.remove("iBATIS");

        System.out.println("총 객체 수 : " + set.size());

        iterator = set.iterator();

        while(iterator.hasNext()) {
            String element = iterator.next();
            System.out.println("\t" + element);
        }

        set.clear();
        if(set.isEmpty()) {
            System.out.println("비어있음");
        }
    }
}
