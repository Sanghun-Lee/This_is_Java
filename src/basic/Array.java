package basic;

/**
 * 배열
 * 배열 생성 및 초기화
 * 다차원 배열 생성 및 초기화
 * api를 활용한 배열의 복사
 */

public class Array {
    public static void main(String[] args) {
        // 배열 생성과 동시에 초기화
        int[] arr = new int[] { 1, 2, 3};
        String[] str = new String[] { "lee", "sang", "hun" };

        // 배열을 n개만 미리 생성해 놓을 때
        int[] map = new int[10];    // 10개 생성
        // 나중에 n개를 생성하는 법
        int[] arr2;
        arr2 = new int[10];         // 10개 생성

        // 배열길이만큼 반복
        for(int i = 0; i < str.length; i++)
            System.out.println("str[" + i + "] : " + str[i]);

        // main함수의 String[] args는 argument들을 가진다.
        // c처럼 파일이름같은건 가지지 않고, argument만 가진다.
        // java test.java 10 20 >> args[0] : 10

        /* ------ 다차원 배열 -------- */
        int[][] map2 = { {1, 2, 3}, {10, 20, 30}};  // 생성과 동시에 초기화
        int[][] arr3 = new int[2][3]; // 2 * 3 배열 생성
        System.out.println(arr3.length);    // 2 출력
        System.out.println(arr3[0].length); // 3 출력

        // 이런식으로도 생성 가능
        int[][] arr4 = new int[3][];    // 세로 크기가 3인 배열만 생성
        arr4[0] = new int[10];          // 0번째 행은 길이가 10인 배열 생성
        arr4[1] = new int[20];          // 1번째 행은 길이가 20인 배열 생성
        arr4[2] = new int[10];

        /* ------ 배열 복사 api -------- */
        // System.arraycopy(복사할 배열, 복사할 배열의 시작점, 붙일 배열, 붙일 배열의 시작점, 복사할 길이);
        System.arraycopy(arr, 0, arr2, 0, arr.length);      // arr의 0번째 부터 arr.length만큼 arr2의 0번째 부터 복사한다.
        System.arraycopy(map2, 0, arr4, 1, arr3.length);    // 2차원 배열의 복사도 가능하다.
        System.out.println(arr4[1][1]);


    }
}