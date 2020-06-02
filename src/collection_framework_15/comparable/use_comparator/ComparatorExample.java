package collection_framework_15.comparable.use_comparator;

import java.util.Iterator;
import java.util.TreeSet;

public class ComparatorExample {
    public static void main(String[] args) {
        /*
        TreeSet<Fruit> treeSet = new TreeSet<>();
        // Fruit이 Comparable을 구현하지 않았기 때문에 예외 발생
        treeSet.add(new Fruit("포도", 3000));
        treeSet.add(new Fruit("수박", 5000));
        treeSet.add(new Fruit("딸기", 6000));
        */

        // 내림차순 정렬자를 제공한다.
        TreeSet<Fruit> treeSet = new TreeSet<>(new DescendingComparator());
        // 가격을 기준으로 내림차순 정렬된다.
        treeSet.add(new Fruit("포도", 3000));
        treeSet.add(new Fruit("수박", 5000));
        treeSet.add(new Fruit("딸기", 6000));
        Iterator<Fruit> iterator = treeSet.iterator();
        while(iterator.hasNext()) {
            Fruit fruit = iterator.next();
            System.out.println(fruit.name + " : " + fruit.price);
        }
    }
}
