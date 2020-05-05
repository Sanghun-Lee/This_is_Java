package api_11.arrays;

// 배열의 복사 - Arrays class 에서 사용한다.
// 1. copyOf(원본배열, 복사할 길이)
// 2. copyOfRange(원본배열, 시작인덱스, 끝인덱스)
// 3. System.arraycopy(원본배열, 원본시작인덱스, 타겟배열, 타겟시작인덱스, 복새갯수)
// 와 같은 방법으로 복사한다.

import java.util.Arrays;

public class ArrayCopyExample {
    public static void main(String[] args) {
        char[] arr1 = {'J', 'A', 'V', 'A'};

        // 방법 1
        char[] arr2 = Arrays.copyOf(arr1, arr1.length); // arr1 전체를 arr2에 복사
        System.out.println(Arrays.toString(arr2));

        // 방법 2
        char[] arr3 = Arrays.copyOfRange(arr1, 1, 3);   // arr1[1] ~ arr1[2]를 arr2[0] ~ arr2[1]로 복사
        System.out.println(Arrays.toString(arr3));

        // 방법 3
        char[] arr4 = new char[arr1.length];
        System.arraycopy(arr1, 0, arr4, 0, arr1.length);    // arr1 전체를 arr4로 복사
        for(int i = 0; i < arr4.length; i++) {
            System.out.println("arr4[" + i + "] = " + arr4[i]);
        }
    }
}
