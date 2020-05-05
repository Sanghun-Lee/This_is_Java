package api_11.date_calendar;

// 달력은 표현한 클래스 : Calendar 클래스
// 날짜는 나라와 시간대 마다 다르기 때문에 Calendar 클래스는 추상클래스이다.
// 그래서 사용자가 적절한 시간대 타입으로 Override 해야된다.
// 하지만 국제표준을 쓸 꺼 라면 getInstance() 메소드로 지금 운영체제에서 사용하는 달력체계로 값을 받을 수 있다.
// 다른 달력체계로 받고싶으면 getInstance 메소드에 매개변수로 원하는 시간대를 넘겨주여야 한다.
// 시간대는 TimeZone 클래스가 가지고 있다.

// TimeZone = timeZone = TimeZone.getTimeZone("America/Los_Angeles");
// Calendar now = Calendar.getInstance(timeZone);

// 아래 예제는 운영체제의 시간대를 기준으로 Calendar 를 얻는 코드이다.

import java.util.Calendar;

public class CalenderExample {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();

        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH);
        int day = now.get(Calendar.DAY_OF_MONTH);

        int week = now.get(Calendar.DAY_OF_WEEK);
        String strWeek = null;
        switch(week) {
            case Calendar.MONDAY:
                strWeek = "월";
                break;
            case Calendar.TUESDAY:
                strWeek = "화";
                break;
            case Calendar.WEDNESDAY:
                strWeek = "수";
                break;
            case Calendar.THURSDAY:
                strWeek = "목";
                break;
            case Calendar.FRIDAY:
                strWeek = "금";
                break;
            case Calendar.SATURDAY:
                strWeek = "토";
                break;
            case Calendar.SUNDAY:
                strWeek = "일";
                break;
        }

        int amPm = now.get(Calendar.AM_PM);
        String strAmPm = null;
        if(amPm == Calendar.AM) {
            strAmPm = "오전";
        } else {
            strAmPm = "오후";
        }

        int hour = now.get(Calendar.HOUR);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);

        System.out.print(year + "년 ");
        System.out.print(month + "월 ");
        System.out.print(day + "일 ");
        System.out.print(strWeek + "요일 ");
        System.out.print(strAmPm + " ");
        System.out.print(hour + "시 ");
        System.out.print(minute + "분 ");
        System.out.print(second + "초 ");
    }
}
