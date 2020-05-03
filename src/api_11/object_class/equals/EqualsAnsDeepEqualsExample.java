package api_11.object_class.equals;

import java.util.Arrays;
import java.util.Objects;

// 객체끼리의 equals 는 가리키는 객체가 다르면 (hashCode()) false 를 return 한다. (23번째 줄)
// deepEquals 는 서로 다른 배열일 경우 항목 값이 모두 같다면 true 를 return 한다.

public class EqualsAnsDeepEqualsExample {
    public static void main(String[] args) {
        Integer o1 = 100;
        Integer o2 = 200;

        System.out.println(Objects.equals(o1, o2));
        System.out.println(Objects.equals(o1, null));
        System.out.println(Objects.equals(null, o2));
        System.out.println(Objects.equals(null, null));
        System.out.println(Objects.deepEquals(o1, o2) + "\n");

        Integer[] arr1 = {1, 2, 3};
        Integer[] arr2 = {1, 2, 3};

        System.out.println(Objects.equals(arr1, arr2));
        System.out.println(Objects.deepEquals(arr1, arr2));
        System.out.println(Arrays.deepEquals(arr1, arr2));
        System.out.println(Objects.deepEquals(null, arr2));
        System.out.println(Objects.deepEquals(arr1, null));
        System.out.println(Objects.deepEquals(null, null));
    }
}
