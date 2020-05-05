package api_11.math;

// Math.random() 메소드와는 다르게
// Random 클래스가 존재한다.
// Random 클래스는 boolean, int, long, float, double 난수를 얻을 수 있다.
// 그리고 객채를 만들 때 seed 값을 넣어주어서 같은 seed 값이면 같은 난수를 생성할 수 있다.

import java.util.Arrays;
import java.util.Random;

public class RandomExample {
    public static void main(String[] args) {
        // 선택 번호
        int[] selectNumber = new int[6];        // 선택 번호 6개가 저장될 배열 생성
        Random random = new Random(3);    // 선택 번호를 얻기 위해서 Random 객체 생성
        System.out.print("선택 번호 : ");
        for(int i = 0; i < 6; i++) {
            selectNumber[i] = random.nextInt(45) + 1;   // nextInt(value) : 0 ~ value 사이의 값에 해당하는 랜덤 수를 리턴
            System.out.print(selectNumber[i] + " ");
        }
        System.out.println();

        // 당첨 번호
        int[] winningNumber = new int[6];
        random = new Random(5);
        System.out.print("당첨 번호 : ");
        for(int i = 0; i < 6; i++) {
            winningNumber[i] = random.nextInt(45) + 1;
            System.out.print(winningNumber[i] + " ");
        }
        System.out.println();

        // 당첨 여부
        Arrays.sort(selectNumber);  // 두 배열을 비교하기 전에 정렬시킨다.
        Arrays.sort(winningNumber);
        boolean result = Arrays.equals(selectNumber, winningNumber);
        System.out.print("당첨 여부 : ");
        if(result) {
            System.out.println("1등에 당첨되셨습니다.");
        } else {
            System.out.println("당첨되지 않았습니다.");
        }
    }
}
