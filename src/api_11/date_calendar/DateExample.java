package api_11.date_calendar;

// 컴퓨터의 현재날짜를 읽는 방법 : Date 객체를 사용한다.
// Date now = new Date();
// Date 객체에서 현재날짜를 문자열로 얻고 싶다면 toString 메소드를 이용한다.
// String date = now.toString();

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {
    public static void main(String[] args) {
        Date now = new Date();
        String strNow1 = now.toString();
        System.out.println(strNow1);

        // 특정 문자열 포팻으로 얻고싶으면 java.text.SimpleDateFormat 메소드를 이용하면 된다.
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
        String strNow2 = sdf.format(now);
        System.out.println(strNow2);
    }
}
