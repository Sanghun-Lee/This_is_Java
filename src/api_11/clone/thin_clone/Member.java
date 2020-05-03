package api_11.clone.thin_clone;

// Cloneable interface 를 구현함으로써 객체를 복사할 수 있단는 표시를 해 놓아야 한다.
// Cloneable interface 는 메소드 선언이 없지만, 설계자가 복제를 허용한다는 의도적인 표시이다.
// 얕은 복제는 기본타입의 경우(int, double) 값의 복사가 일어나고
// 참조타입(배열, 객체)인 경우 객체 번지 수(주솟값) 복사가 일어난다. (결국 같은곳을 참조하는 것이다.)

public class Member implements Cloneable {
    public String id;
    public String name;
    public String password;
    public int age;
    public boolean adult;

    public int[] array;     // 참조타입의 변수

    public Member(String id, String name, String password, int age, boolean adult) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.adult = adult;
    }

    public Member getMember() {
        Member cloned = null;
        try {
            // clone() 메소드는 리턴 타입이 Object 이기 때문에 Member 타입으로 캐스팅 해야된다.
            // class 에서 Cloneable interface 를 구현해 놓지 않으면 CloneNotSupportException 예외가 발생하여 복제가 실패하게 된다.
            // throw 로 예외를 일으킬 수 있으니 try - catch 구문이 필요하다.
            cloned = (Member) clone();
        } catch (CloneNotSupportedException e) {}
        return cloned;
    }

    public String arrayToString() {
        String str = "";
        for(int number : array) {
            str = str + number + " ";
        }
        return str;
    }
}
