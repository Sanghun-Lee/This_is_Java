package generic_13.start.no_generic;

// 제네릭 타입 없이 모든 객체를 받을 수 있는 class 를 생성한다.
// Object를 이용한다.

public class Box1 {
    private Object object;
    public void setObject(Object object) {
        this.object = object;
    }
    public Object getObject() {
        return this.object;
    }
}
