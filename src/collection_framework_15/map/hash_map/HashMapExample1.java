package collection_framework_15.map.hash_map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample1 {
    public static void main(String[] args) {
        // Map collection create
        Map<String, Integer> map = new HashMap<>();

        // 객체 저장
        map.put("신용권", 95);
        map.put("홍길동", 80);
        map.put("동장군", 88);
        map.put("홍길동", 90); // 2번째 넣은 것과 key가 같기 때문에 value만 최신화
        System.out.println("총 Entry 수 : " + map.size());

        // 객체 찾기
        System.out.println("\t홍길동 : " + map.get("홍길동"));
        System.out.println();

        // 객체를 하나씩 처리
        Set<String> keySet = map.keySet();  // key를 Set 형식으로 만든 후, 리턴해 준다.
        Iterator<String> keyIterator = keySet.iterator();
        while(keyIterator.hasNext()) {
            String key = keyIterator.next();
            Integer value = map.get(key);
            System.out.println("\t" + key + " : " + value);
        }
        System.out.println();

        // 객체 삭제
        map.remove("홍길동");
        System.out.println("총 Entry 수 : " + map.size());

        // 객체를 하나씩 처리
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();

        while(entryIterator.hasNext()) {
            Map.Entry<String, Integer> entry = entryIterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("\t" + key + " : " + value);
        }
        System.out.println();

        // 객체 전체 삭제
        map.clear();
        System.out.println("총 Entry 수 : " + map.size());
    }
}
