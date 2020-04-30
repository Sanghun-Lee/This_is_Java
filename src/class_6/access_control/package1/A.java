package class_6.access_control.package1;

public class A {
    /****** 접근 제한자 ******/
    // 1. public    : 모든 패키지에서 접근 가능하다.
    // 2. protected : 같은 패키지에서는 항상 접근 가능하고, 다른 패키지는 자식 클래스에서만 접근 가능하다.
    // 3. default   : 같은 패키지에서만 접근 가능하다.
    // 4. private   : 클래스 내부에서만 사용 가능하고 다른 클래스에서는 접근할 수 없다.

    public int public_field;
    protected int protected_field;
    int default_field;
    private int private_field;

    public void public_method() {}
    protected void protected_method() {}
    void default_method() {}
    private void private_method() {}


    public A() {
        public_field = 1;   // 같은 class 라서 가능하다.
        protected_field = 1;
        default_field = 1;
        private_field = 1;  // 모두 가능하다.

        public_method();
        protected_method();
        default_method();
        private_method();   // 같은 class 라서 위 8개 모두 접근 가능하다.
    }
}
