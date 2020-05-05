package api_11.arrays.sorting;

// Arrays.sort() 메소드를 사용하면 자동으로 오름차순으로 정렬된다.
// 사용자 정의 클래스 타입인 경우 클래스가 Comparable 인터페이스를 구현하고 있어야 한다.

public class Member implements Comparable<Member> {
    public String name;
    public Member(String name) {
        this.name = name;
    }

    // compareTo 메소드는
    // 호출한 자기 자신이 매개값보다 낮을 경우 음수
    // 같은 경우 0
    // 높을 경우 양수를 리턴한다.
    // 이렇게 되면 오름차순으로 정렬된다.
    // 내림차순으로 정렬하고싶으면 반대로 만들면 된다.
    @Override
    public int compareTo(Member member) {
        return name.compareTo(member.name);
    }
}
