package nested_9.anonymous.local_class;

public class Anonymous {
    private int field1;

    public void method(final int arg1, int arg2) {
        final int var1 = 0;
        int var2 = 0;

        field1 = 10;    // (o) - 로컬 클래스, 인터페이스가 호출된 메소드의 매개변수, 지역변수만이다.

        // arg1 = 20;   // (x)
        // arg2 = 20;   // (x) - 로컬 클래스, 인터페이스가 해당 함수의 변수를 사용하면 무조건 final 이 되기 때문에 수정하면 안된다.

        // var1 = 30;   // (x)
        // var2 = 40;   // (x) - 위와 같은 이유이다.


        // 로컬 클래스의 익명 구현 객체
        // 로컬 클래스를 만드는것이 아니라, 익명으로 바로 만들어버린다.
        Calculatable calc = new Calculatable() {
            @Override
            public int sum() {
                int result = field1 + arg1 + arg2 + var1 + var2;
                return result;
            }
        };

        // 익명 구현 객체로 만들지 않았다면 코드가 아래와 같아진다.
        class calculate implements Calculatable {
            @Override
            public int sum() {
                int result = field1 + arg1 + arg2 + var1 + var2;
                return result;
            }
        }   // 구현 클래스를 로컬 클래스로 만들고 난 후,

        Calculatable calc2 = new calculate();   // 인터페이스 변수에 대입한다.

        System.out.println(calc.sum());
        System.out.println(calc2.sum());        // 그리고 사용할 수 있다.
    }
}
