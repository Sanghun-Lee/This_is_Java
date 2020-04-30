package class_6.access_control.package1;

public class B {
    /****** 접근 제한자 ******/
    // 1. public    : 모든 패키지에서 접근 가능하다.
    // 2. protected : 같은 패키지에서는 항상 접근 가능하고, 다른 패키지는 자식 클래스에서만 접근 가능하다.
    // 3. default   : 같은 패키지에서만 접근 가능하다.
    // 4. private   : 클래스 내부에서만 사용 가능하고 다른 클래스에서는 접근할 수 없다.

    // B는 A와 같은 package 상에 있다. >> default 까지 가능하다.

    public B() {
        A a = new A();
        a.public_field = 2;         // 같은 package 라서 가능하다.
        a.protected_field = 2;      // 같은 package 라서 가능하다.
        a.default_field = 2;        // 같은 package 라서 가능하다.
        // a.private_field = 2;     // A class 외부이기 때문에 불가능하다.

        a.public_method();
        a.protected_method();
        a.default_method();
        // a.private_method();      // A class 외부라서 불가능하다.
    }
}
