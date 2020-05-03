package api_11.object_class.toString;

// 객체 문자 정보 toString() - p480
// String toString(Object o)    : o 가 not null 이면 o.toString() 호출 / o 가 null 이면 null 리턴
// String toString(Object o, String nullDefault)    : o가 not null 이면 o.toString() / o가 null 이면 nullDefault 리턴

import java.util.Objects;

public class ToStringExample {
    public static void main(String[] args) {
        String str1 = "홍길동";
        String str2 = null;

        System.out.println(Objects.toString(str1));
        System.out.println(Objects.toString(str2));
        System.out.println(Objects.toString(str2, "이름이 없습니다."));
    }
}
