package nested_9.local_class;

/*** 로컬 클래스에서 사용 제한 ***/

/**
 * 로컬 클래스에 있는 로컬 메소드는 (method) 로컬 클래스를 생성하는 메서드(method1)의 매개변수와 지역변수를 가져와 쓸 수 있다.
 * 하지만 로컬 클래스를 생성하는 메서드(method1)는 종료가 되어도, 로컬 클래스(Inner)는 종료가 안 될 수 있다.
 * 그래서 method1의 매개변수와 지역변수는 method1의 종료와 함께 stack에서 삭제되는데, 로컬 클래스(Inner)는 계속 실행중 이기 때문에,
 * 매개변수(arg)와 로컬변수(localVariable)는 로컬 클래스(Inner)에 복사 해야 한다.
 * Java 7 이전에는 final 변수만 쓸 수 있고, 해당 변수는 로컬 클래스의 로컬 메소드(method)의 지역변수로 복사한다.
 * Java 8 이후는 final 변수 뿐만 아니라, 일반 변수도 method에서 가져와 쓸 수 있다. 그래도 final의 특징은 남아 있기 때문에, 수정은 불가능하다.
 * final을 붙인 변수는 로컬 메소드(method)의 지역변수로 들어가게되고, final을 붙이지 않은 변수는 로컬 클래스(Inner)의 필드로 들어가게 된다.
 */


public class Outter {
    // 자바 7 이전
    public void method1(final int arg) {
        final int localVariable = 1;
        // arg = 100;           // (x) - final 변수라서
        // localVariable = 100; // (x)
        class Inner {           // 로컬 클래스
            public void method() {
                int result = arg + localVariable;
            }
        }

        // 로컬 클래스 호출방법
        Inner inner = new Inner();
        inner.method();
    }

    // 자바 8 이후
    public void method2(int arg) {
        int localVariable = 1;
        // arg = 100;               // (x) - final 변수가 아니라도 로컬 클래스의 로컬 메소드에서 사용하게 되면 final의 성질을 가진다.
        // localVariable = 100;     // (x) - 위와 같은 이유
        class Inner {
            public void method() {
                int result = arg + localVariable;
            }
        }
    }

    /*** 중첩 클래스에서 바깥 클래스 참조 얻기 ***/
    String field = "Outter-Field";              // 바깥 클래스의 필드

    void method() {
        System.out.println("Outter-Method");    // 바깥 클래스의 메소드
    }

    class Nested {
        String field = "Nested-Field";
        void method() {
            System.out.println("Nested-Method");
        }

        void print() {
            System.out.println(this.field);
            this.method();
            System.out.println(Outter.this.field);  // 바깥 클래스의 필드를 참조하기 위해선 (바깥 클래스 이름).this.(필드 이름)을 쓰면 된다.
            Outter.this.method();
        }
    }
}
