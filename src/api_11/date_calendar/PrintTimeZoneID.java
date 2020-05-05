package api_11.date_calendar;

// Calendar 클래스의 getInstance 메소드에 매개변수로 사용할 수 있는 시간대 id 들을 출력

import java.util.TimeZone;

public class PrintTimeZoneID {
    public static void main(String[] args) {
        String[] availableIDs = TimeZone.getAvailableIDs();
        for(String id : availableIDs) {
            System.out.println(id);
        }
    }
}
