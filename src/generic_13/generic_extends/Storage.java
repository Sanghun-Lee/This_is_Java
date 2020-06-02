package generic_13.generic_extends;

// 제네릭 타입을 갖는 인터페이스

public interface Storage<T> {
    public abstract void add(T item, int index);
    public abstract T get(int index);
}
