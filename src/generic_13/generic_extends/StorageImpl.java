package generic_13.generic_extends;

// 제네릭 타입을 갖는 인터페이스의 구현 클래스
// 구현클래스는 무조건 인터페이스와 같은 제네릭 타입이어야 한다. (더 있어도 상관없다 <T, M> 이라도 상관없다.

public class StorageImpl<T> implements Storage<T> {
    private T[] array;

    public StorageImpl(int capacity) {
        this.array = (T[])(new Object[capacity]);
    }


    @Override
    public void add(T item, int index) {
        array[index] = item;
    }

    @Override
    public T get(int index) {
        return array[index];
    }
}