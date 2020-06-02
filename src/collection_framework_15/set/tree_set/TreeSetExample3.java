package collection_framework_15.set.tree_set;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample3 {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("apple");
        treeSet.add("forever");
        treeSet.add("description");
        treeSet.add("ever");
        treeSet.add("zoo");
        treeSet.add("base");
        treeSet.add("guess");
        treeSet.add("cherry");

        System.out.println("[c - f 사이의 단어 검색]");
        // treeSet에서 c <= value <= f 인 단어 검색
        // true 값을 false 로 바꾸면 '='가 없어진다.
        NavigableSet<String> rangeSet = treeSet.subSet("c", true, "f", true);
        for(String word : rangeSet) {
            System.out.println(word);
        }
    }
}
