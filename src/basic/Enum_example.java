package basic;

/**
 * Enum의 사용
 *
 */

public class Enum_example {
    public static void main(String[] args) {
        /* ----- enum의 기본적으로 지원하는 메서드들 사용 ----- */
        // name() 메서드
        Week today = Week.MONDAY;
        String name = today.name(); // today가 지칭하는 enum의 값을 string으로 변환해서 리턴한다.
        // name : "MONDAY"

        // ordinal() 메서드 : enum변수가 가진 enum객체의 순번을 리턴한다.
        int ordinal = today.ordinal();
        System.out.println(ordinal);    // 0이 출력된다. // today가 SUNDAY면 6이 출력된다.

        // compareTo() : 두 enum이 가리키는 변수의 차이를 출력한다.
        Week day1 = Week.SATURDAY;    // 5
        Week day2 = Week.WEDNESDAY;    // 2
        int result1 = day1.compareTo(day2); // (5 - 2)인 3이 저장
        int result2 = day2.compareTo(day1); // (2 - 5)인 -3이 저장

        System.out.println(result1);
        System.out.println(result2);

        // valueOf 메소드 : string을 enum에 해당하는 객체로 바꿔준다.
        Week day = Week.valueOf("SATURDAY");
        System.out.println(day == Week.SATURDAY);   // 참인 1이 리턴된다.

        // values 메소드 : 모든 enum의 인자들이 배열로 만들어져서 리턴된다.
        Week[] days = Week.values();
        for(Week t : days)
            System.out.print(t + " ");
    }
}
