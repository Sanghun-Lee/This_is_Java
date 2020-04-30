package inheritance_7.abstract_;

public class SmartPhone extends Phone {
    // constructor
    public SmartPhone(String owner) {
        super(owner);   // super를 이용해서 Phone의 생성자를 호출했다.
    }

    // method
    public void internet_search() {
        System.out.println("인터넷 검색을 합니다.");
    }
}
