package generic_13.start.use_generic;

public class BoxExample {
    public static void main(String[] args) {
        Box<String> box = new Box<String>();
        box.setT("Hello");
        String str = box.getT();    // 강제 타입 변환 할 필요가 없다.

        Box<Integer> box2 = new Box<Integer>();
        box2.setT(6);
        int value = box2.getT();
    }
}
