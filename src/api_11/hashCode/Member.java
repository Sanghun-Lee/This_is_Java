package api_11.hashCode;

public class Member {
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
            Member member = (Member) obj;
            if(id.equals(member.getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id.hashCode();       // id가 동일한 문자열일 경우 같은 hashcode 를 리턴한다.
    }
}
