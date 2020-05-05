package api_11.wrapper;

// 자바의 기본타입의 값을 갖는 객체를 생성할 수 있다.
// 박싱된 기본 타입의 값은 변경할 수 없다. 변경하려면 새로운 객체를 생성 후 대입해야 한다.

// 기본 타입의 값을 포장 객체로 만드는 과정      : 박싱 (Boxing)
// 포장 객체에서 기본 타입의 값을 얻어내는 과정   : 언박싱 (UnBoxing)

public class BoxingUnBoxingExample {
    public static void main(String[] args) {
        // Boxing
        Integer obj1 = new Integer(100);        // 기본타입의 값을 주어도 되고
        Integer obj2 = new Integer("200");         // 문자열로 값을 주어도 된다.
        Integer obj3 = Integer.valueOf(300);
        Integer obj4 = Integer.valueOf("400");

        // UnBoxing
        int value1 = obj1.intValue();
        int value2 = obj2.intValue();
        int value3 = obj3.intValue();
        int value4 = obj4.intValue();

        System.out.println(value1);
        System.out.println(value2);
        System.out.println(value3);
        System.out.println(value4);
    }
}
