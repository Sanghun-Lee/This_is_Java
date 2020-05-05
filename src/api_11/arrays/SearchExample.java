package api_11.arrays;

// 배열의 항목 검색
// 배열의 항목을 검색하기 위해선 Arrays.sort 메소드로 정렬을 먼저 해야된다.
// 그리고 Arrays.binarySearch 메소드를 이용해서 찾으면 된다.
// 이진탐색으로 검색을 한다.

// 인덱스가 없으면 음수를 리턴한다. (값은 정해져있지 않은것 같다)

import api_11.arrays.sorting.Member;

import java.util.Arrays;

public class SearchExample {
    public static void main(String[] args) {
        // 기본타입 검색
        int[] scores = {99, 97, 95};
        Arrays.sort(scores);
        int index = Arrays.binarySearch(scores, 99);    // 99는 맨 마지막에 있기 때문에 인덱스로 2번 값이 리턴된다.
        System.out.println("찾은 인덱스 : " + index);
        System.out.println();

        // 문자열 검색
        String[] names = { "홍길동", "박동수", "김민수" };
        Arrays.sort(names);
        index = Arrays.binarySearch(names, "홍길동");  // 홍길동 값도 맨 마지막에 있기 때문에 인덱스로 2번 값이 리턴된다.
        System.out.println("찾은 인덱스 : " + index);

        System.out.println();

        Member m1 = new Member("홍길동");
        Member m2 = new Member("박동수");
        Member m3 = new Member("김민수");

        Member[] members = { m1, m2, m3 };
        Arrays.sort(members);
        index = Arrays.binarySearch(members, m1);       // m1 객체또한 홍길동으로 맨 마지막에 있기 때문에 인덱스로 2번값이 리턴된다.
        System.out.println("찾은 인덱스 : " + index);

    }
}
