package generic_13.method;

// 두 개의 제네릭 타입을 갖는 Pair class

public class Pair<K, V> {
    private K key;
    private V value;

    public Pair (K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }
}
