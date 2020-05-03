package api_11.equals;

/*** equals method ***/
// Object 에 정의되어 있다.

// 아무것도 extends 하지 않으면 자동으로 Object 를 extends 한다.
public class Member extends Object {
    private String id;

    public Member(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Member) {
            Member member = (Member) obj;       // Object 로 들어온 변수를 Member 로 강제 타입 변환 시킨다.
            if(this.id == member.getId())       // 나의 id 값과 obj 의 id 값이 같으면 return true;
                return true;
        }
        return false;   // Member 타입이 아니거나 id 필드값이 다른 경우 false 리턴
    }
}
