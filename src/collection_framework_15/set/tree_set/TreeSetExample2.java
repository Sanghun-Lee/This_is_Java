package collection_framework_15.set.tree_set;

import java.util.NavigableSet;
import java.util.TreeSet;

// 정렬하기

public class TreeSetExample2 {
    public static void main(String[] args) {
        TreeSet<Integer> scores = new TreeSet<Integer>();
        scores.add(new Integer(98));
        scores.add(new Integer(87));
        scores.add(new Integer(75));
        scores.add(new Integer(95));
        scores.add(new Integer(80));

        NavigableSet<Integer> descendingSet = scores.descendingSet();
        for(Integer score : descendingSet) {
            System.out.println(score + " ");
        }
        System.out.println();

        // 내림차순을 다시 내림차순으로 정렬해서 오름차순으로 만들기
        NavigableSet ascendingSet = descendingSet.descendingSet();
        for(Integer score : descendingSet) {
            System.out.println(score + " ");
        }
    }
}
