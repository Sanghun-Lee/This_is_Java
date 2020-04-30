package class_6.access_control.package2;

import class_6.access_control.package1.A;

public class D extends A {
    /****** 접근 제한자 ******/
    // 1. public    : 모든 패키지에서 접근 가능하다.
    // 2. protected : 같은 패키지에서는 항상 접근 가능하고, 다른 패키지는 자식 클래스에서만 접근 가능하다.
    // 3. default   : 같은 패키지에서만 접근 가능하다.
    // 4. private   : 클래스 내부에서만 사용 가능하고 다른 클래스에서는 접근할 수 없다.

    // A와 D는 다른 package 상에 있지만, D는 A의 자식이다. (extends)

    public D () {
        A a = new A();

        a.public_field = 4;         // public 이라서 가능하다.
        protected_field = 4;        // 상속했기 때문에 바로 접근 가능하다.
        //  a.protected_field = 4;  // 객체 a를 통해서는 불가능하다.
        // default_field = 4;       // default 로 생성했기 때문에 상속해도 접근이 불가능하다.
        // private_field = 4;

        a.public_method();          // public이라서 가능
        protected_method();         // protected 는 상속했으니 상속된 결과로 호출 가능하다.
        // a.protected_method();
        // default_method();        // 불가능
        // private_method();

    }

}
