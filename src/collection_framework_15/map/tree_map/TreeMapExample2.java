package collection_framework_15.map.tree_map;

// 객체 정렬하기

import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapExample2 {
    public static void main(String[] args) {
        TreeMap<Integer, String> scores = new TreeMap<>();
        scores.put(new Integer(87), "홍길동");
        scores.put(88, "first");
        scores.put(92, "second");
        scores.put(75, "third");
        scores.put(98, "fourth");

        NavigableMap<Integer, String> descendingMap = scores.descendingMap();
        Set<Map.Entry<Integer, String>> descendingEntrySet = descendingMap.entrySet();
        for(Map.Entry<Integer, String> entry : descendingEntrySet) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println();

        NavigableMap<Integer, String> ascendingMap = descendingMap.descendingMap();
        Set<Map.Entry<Integer, String>> ascendingEntrySet = ascendingMap.entrySet();
        for(Map.Entry<Integer, String> entry : ascendingEntrySet) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
