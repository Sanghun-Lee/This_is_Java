package class_6.singleton;

public class Singleton {
    /****** 싱글톤 : 하나의 객체만 가지고 있다. *******/
    // 1. 자신의 타입인 정적 필드를 하나 선언
    // 2. 자신의 객체를 생성해 초기화 한다.
    // 3. 정적 메소드인 getInstance()를 선언하고 자신의 객체를 리턴해준다.

    // private static Singleton singleton = new Singleton();    // 이렇게 한번에 작성하면 된다.
    private static Singleton singleton; // 1.자신의 타입인 정적 필드를 하나 선언한다.
    static {
        singleton = new Singleton();    // 2. 자신의 객체를 생성해 초기화 한다.
    }

    private Singleton() {}  // 기본생성자를 private으로 만들어서 외부에서 해당 객체를 만들수 없도록 만든다.

    // 3. 정적 메소드인 getInstance()를 선언하고 자신의 객체를 리턴해준다.
    static Singleton getInstance() {
        return singleton;
    }
}
// 이렇게 되면 Singleton객체를 생성할 수 없다 (기본생성자가 private이라서)
// Singleton의 객체를 받기 위해선 getInstance()함수를 이용해서 받을 수 밖에 없는데,
// getInstance함수는 기존에 생성한 인스턴스 하나 (singleton변수에 저장되어있는 객체)만 리턴하기 때문에
// 결국에는 하나의 객체만 가지고 있는 셈이다.