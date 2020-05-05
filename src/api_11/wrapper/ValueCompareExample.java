package api_11.wrapper;

// 박싱된 두 객체의 값을 비교하기 위해선 == or != 연산을 사용하면 안된다.
// Boolean, Char, Byte, Integer, Short 는 가능하다. 그러나 이것도 값의 볌위가 -128 ~ 127일 경우만 된다.
// 그러니 .equals() 메소드를 이용해서 비교하는게 바람직한다.

public class ValueCompareExample {
    public static void main(String[] args) {
        System.out.println("[-128 ~ 127 초과값일 경우]");
        Integer obj1 = 300;
        Integer obj2 = 300;
        System.out.println("== 결과 : " + (obj1 == obj2));
        System.out.println("언박싱 후 == 결과 : " + (obj1.intValue() == obj2.intValue()));
        System.out.println("equals 메소드 결과 : " + obj1.equals(obj2));
        System.out.println();

        System.out.println("[-128 ~ 127 범위값일 경우]");
        Integer obj3 = 100;
        Integer obj4 = 100;

        System.out.println("== 결과 : " + (obj3 == obj4));
        System.out.println("언박싱 후 == 결과 : " + (obj3.intValue() == obj4.intValue()));
        System.out.println("equals 메소드 결과 : " + obj3.equals(obj4));
    }
}
