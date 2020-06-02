package generic_13.multi_type;

// 두 개 이상의 제네릭 타입을 갖는 class 예시
// T와 M은 아무 알파벳이나 올 수 있다.
public class Product<T, M> {
    private T kind;
    private M model;

    public T getKind() {
        return this.kind;
    }
    public M getModel() {
        return this.model;
    }

    public void setKind(T kind) {
        this.kind = kind;
    }
    public void setModel(M model) {
        this.model = model;
    }
}
