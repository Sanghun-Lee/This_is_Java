package generic_13.method;

import generic_13.start.use_generic.Box;

public class BoxingMethodExample {
    public static void main(String[] args) {
        Box<Integer> box1 = Util.<Integer>boxing(300);
        int value = box1.getT();

        Box<String> box2 = Util.boxing("홍길동");
        String str = box2.getT();
    }
}
