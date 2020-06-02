package generic_13.method;

// 두 개의 제네릭 매개변수를 갖는 Pair 클래스를 이용해서 compare 메소드를 구현해 보자.

public class Util2 {
    // compare 메소드의 매개변수 Pair<K, V> 는 두 개의 제네릭 타입을 가지기 때문에
    // 메소드 선언 전에 두 개의 제네릭 변수가 있다고 선언해야 한다.
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        boolean keyCompare = p1.getKey().equals(p2.getKey());
        boolean valueCompare = p1.getValue().equals(p2.getValue());
        return keyCompare && valueCompare;
    }
}
