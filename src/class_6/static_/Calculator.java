package class_6.static_;

public class Calculator {
    // static 키워드로 정적필드 생성
    static double pi = 3.14;    // pi 값은 어떤 인스턴스에서든 동일하기 때문에 static 으로 생성하는것이 좋다.

    static int val1 = 20;
    static int val2 = 30;
    static int val3;

    int field1;
    void method1(String message) {
        System.out.println("Calculator의 method1 메서드, message : " + message);
    }

    // 정적 초기화 블록 : 정적변수를 해당 초기화 블록에서 초기화 한다.
    static {
        val3 = val1 + val2;
        // field1 = 3;  // 정적 초기화 블록에는 class필드는 올 수 없다.
    }

    static {    // 정적 초기화 블록은 여러개 올 수 있다.
        val3 = 20 + 1;
    }

    // 정적 메서드
    static int plus(int x, int y) {
        return x + y;
    }

    static int minus(int x, int y) {
        return x - y;
    }

    static void Method3() {
        // this.field1 = 10;   // field1변수는 class 필드이기 때문에 인스턴스가 없어서 컴파일 에러를 일으킨다.
        // method1();   // method1도 class 메서드이기 때문에 인스턴스가 없어서 컴파일 에러를 일으킨다.
        val3 = 30;
        System.out.println("plus(20, 15) : " + plus(20, 15));

        // class 메서드인 method1을 호출하려면 클래스를 생성해야 한다.
        Calculator calc = new Calculator();
        calc.method1("method1 성공적 호출");
    }

}
