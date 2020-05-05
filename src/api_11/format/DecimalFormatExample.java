package api_11.format;

// 숫자를 일정 형식에 맞게 만들어주는 class 이다.
// 이것은 자바다1 page 543

import java.text.DecimalFormat;

public class DecimalFormatExample {
    public static void main(String[] args) {
        double num = 1234567.89;

        DecimalFormat df = new DecimalFormat("0");
        System.out.println( df.format(num) );

        df = new DecimalFormat("0.0");
        System.out.println( df.format(num) );

        df = new DecimalFormat("00000000000.0000000");
        System.out.println( df.format(num) );

        df = new DecimalFormat("#");
        System.out.println( df.format(num) );

        df = new DecimalFormat("#.#");
        System.out.println( df.format(num) );

        df = new DecimalFormat("########.######");
        System.out.println( df.format(num) );

        df = new DecimalFormat("#.0");
        System.out.println( df.format(num) );

        df = new DecimalFormat("+#.0");
        System.out.println( df.format(num) );

        df = new DecimalFormat("-#.0");
        System.out.println( df.format(num) );

        df = new DecimalFormat("#,###.0");         // 3자리 마다 쉼표 ',' 붙이기
        System.out.println( df.format(num) );

        df = new DecimalFormat("0.0E0");
        System.out.println( df.format(num) );

        df = new DecimalFormat("+#,### ; -#,###");  // ; : 양수, 음수 따로 설정
        System.out.println( df.format(num) );

        df = new DecimalFormat("#.# %");        // % : 100 곱하고 % 적기
        System.out.println( df.format(num) );

        df = new DecimalFormat("\u00A4 #,###"); // \u00A4 : 원화 붙이기
        System.out.println( df.format(num) );

    }
}
