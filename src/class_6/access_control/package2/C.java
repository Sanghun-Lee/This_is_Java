package class_6.access_control.package2;

import class_6.access_control.package1.*;

public class C {
    /****** 접근 제한자 ******/
    // 1. public    : 모든 패키지에서 접근 가능하다.
    // 2. protected : 같은 패키지에서는 항상 접근 가능하고, 다른 패키지는 자식 클래스에서만 접근 가능하다.
    // 3. default   : 같은 패키지에서만 접근 가능하다.
    // 4. private   : 클래스 내부에서만 사용 가능하고 다른 클래스에서는 접근할 수 없다.

    // C와 A는 다른 package 상에 있다.
    public C() {
        A a = new A();

        a.public_field = 3;         // public 으로 설정했기 때문에 가능하다.
        // a.protected_field = 3;   // C는 A의 자식이 아니기 때문에 불가능하다.
        // a.default_field = 3;     // A와 C는 다른 class 라서 불가능하다.
        // a.private_field = 3;     // class 밖이기 때문에 불가능하다.

        a.public_method();          // public 이라서 가능하다.
        // a.protected_method();    // 불가능
        // a.default_method();      // 불가능
        // a.private_method();      // 불가능
    }

}
