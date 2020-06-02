package collection_framework_15.map.tree_map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample1 {
    public static void main(String[] args) {
        TreeMap<Integer, String> scores = new TreeMap<>();
        scores.put(new Integer(87), "홍길동");
        scores.put(88, "first");
        scores.put(92, "second");
        scores.put(75, "third");
        scores.put(98, "fourth");

        Map.Entry<Integer, String> entry = null;

        entry = scores.firstEntry();
        System.out.println("가장 낮은 점수 : " + entry.getKey() + " - " + entry.getValue());

        entry = scores.lastEntry();
        System.out.println("가장 높은 점수 : " + entry.getKey() + " - " + entry.getValue() + "\n");

        entry = scores.lowerEntry(new Integer(90));
        System.out.println("90점 아래 점수 : " + entry.getKey() + " - " + entry.getValue());

        entry = scores.higherEntry(new Integer(90));
        System.out.println("90점 위의 점수 : " + entry.getKey() + " - " + entry.getValue() + "\n");

        entry = scores.floorEntry(new Integer(90));
        System.out.println("90점 이거나 90점 바로 아래 점수 : " + entry.getKey() + " - " + entry.getValue());
        entry = scores.ceilingEntry(new Integer(90));
        System.out.println("90점 이거나 90점 바로 아래 점수 : " + entry.getKey() + " - " + entry.getValue() + "\n");

        while(!scores.isEmpty()) {
            entry = scores.pollFirstEntry();
            System.out.println(entry.getKey() + " - " + entry.getValue() + ", 남은 객체 수 : " + scores.size());
        }
    }
}
