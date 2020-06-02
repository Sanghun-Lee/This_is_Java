package collection_framework_15.map.tree_map;

// 키로 정렬하고 범위 검색하기

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class TreeMapExample3 {
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("apple", new Integer(10));
        treeMap.put("forever", new Integer(60));
        treeMap.put("description", new Integer(40));
        treeMap.put("ever", new Integer(50));
        treeMap.put("zoo", new Integer(10));
        treeMap.put("base", new Integer(20));
        treeMap.put("guess", new Integer(70));
        treeMap.put("cherry", new Integer(30));

        System.out.println("[c ~ f사이의 단어 검색]");
        NavigableMap<String, Integer> rangeMap = treeMap.subMap("c", true, "f", true);
        for(Map.Entry<String, Integer> entry : rangeMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " 페이지");
        }
    }
}
