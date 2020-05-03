package api_11.toString;

import java.util.Date;

// toString 메소드는 Object 의 정보를 "클래스명@16진수해시코드"로 리턴한다.
// 그 자체로는 의미가 거의 없지만, Override 해서 우리가 원하는 정보를 return 하도록 만든다.
// 대표적으로 Date 클래스이다.
// Date 의 toString 메소드는 현재 시스템의 날짜와 시간정보를 리턴해준다.

public class ToStringExample {
    public static void main(String[] args) {
        Object obj = new Object();

        Date obj2 = new Date();

        System.out.println(obj.toString());
        System.out.println(obj2.toString());
    }
}
