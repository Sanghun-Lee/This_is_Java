package generic_13.start.no_generic;

// 제네릭을 사용하지 않는 경우
// 모든 객체를 받을 수 있는 class 를 선언하기 위해선 java 최상위 객체인 Object 를 사용해야 되고,
// 그러면서 값을 넣거나 받을 때 항상 "자동 타입 변환"과 "강제 타입 변환"을 해야되서 성능에 문제가 생긴다.

public class BoxExample {
    public static void main(String[] args) {
        Box1 box1 = new Box1();
        box1.setObject("홍길동");  // 자동 타입 변환 (String > Object)
        String name = (String) box1.getObject(); // 강제 타입 변환 (Object > String)

        box1.setObject(new Apple());     // 자동 타입 변환 (Apple > Object)
        Apple apple = (Apple) box1.getObject(); // 강제 타입 변환 (Object > Apple)
    }
}
