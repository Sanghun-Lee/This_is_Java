package api_11.arrays;

// 배열 항목 비교
// Arrays.equals 메소드는 1차 항목의 값만 비교한다.
// Arrays.deepEquals 메소드는 1차 항목이 서로 다른 배열을 참조할 경우 충접된 배열의 항목까지 비교한다.

import java.util.Arrays;

public class EqualsExample {
    public static void main(String[] args) {
        int[][] original = { {1, 2}, {3, 4} };

        // 얕은 복사 후 비교
        // original[0]과 cloned1[0], original[1]과 cloned1[1]은 모두 같은 객체를 지칭하고있다.
        // 그래서 1차 배열 항목값을 비교해도 true 가 나오고, 2차 배열 항목값을 비교해도 true 가 나온다.
        System.out.println("[ 얕은 복사 후 비교 ]");
        int[][] cloned1 = Arrays.copyOf(original, original.length);
        System.out.println("배열 번지 비교 : " + original.equals(cloned1));
        System.out.println("1차 배열 항목값 비교 : " + Arrays.equals(original, cloned1));
        System.out.println("중첩 배열 항목값 비교 : " + Arrays.deepEquals(original, cloned1));

        // 깊은 복사 후 비교
        // original[0]과 cloned2[0], original[1]과 cloned2[1]은 모두 다른 객체를 지칭한다. 하지만 안에 값은 똑같다.
        // 그래서 1차 배열 항목값은 1차적으론 다른 객체를 지칭하기 때문에 false 가 출력된다.
        // 하지만 2차 배열 항목값을 비교하면 결국 들어있는 값은 똑같기 때문에 true 가 나온다.
        System.out.println("[ 깊은 복사 후 비교 ]");
        int[][] cloned2 = Arrays.copyOf(original, original.length);
        cloned2[0] = Arrays.copyOf(original[0], original[0].length);    // original[0]과 똑같은 객체를 새로 생성해서 cloned2[0]에 저장
        cloned2[1] = Arrays.copyOf(original[1], original[1].length);
        System.out.println("배열 번지 비교 : " + original.equals(cloned2));
        System.out.println("1차 배열 항목값 비교 : " + Arrays.equals(original, cloned2));
        System.out.println("2차 배열 항목값 비교 : " + Arrays.deepEquals(original, cloned2));
    }
}
