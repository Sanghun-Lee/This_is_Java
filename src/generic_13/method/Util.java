package generic_13.method;

// 제네릭 메소드
// 선언 방법은
// [접근 지정자] <타입 파라미터> [리턴타입] [메소드명](매개면수, ...) { [메소드 내용] }
// public <T> int method1 (T t) { ... }
// public <T> T method2(String str) { ... }
// public <T> Box<T> method3(T t) { .... }

import generic_13.start.use_generic.Box;

public class Util {
    public static <T> Box<T> boxing(T t) {
        Box<T> box = new Box<>();
        box.setT(t);
        return box;
    }
}
