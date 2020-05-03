package api_11.toString;

// toString 을 적절하게 Override 해보자.

public class SmartPhone {
    private String company;
    private String os;

    public SmartPhone(String company, String os) {
        this.company = company;
        this.os = os;
    }

    // toString 메소드 재정의
    @Override
    public String toString() {
        return company + ", " + os;
    }
}
