package exception_10.throw_;

/*** Throw 예시 ***/
// throws 는 메소드에서 사용할 수 있다.
// throws 를 쓰게되면, 메소드 실행 중간에 에러가 일어나게 되면, throws [[예외이름]]에 해당된다면
// 해당 메소드를 호출한 부분에서 예외를 처리하도록 해준다.

public class ThrowsExample {
    public static void main(String[] args) {
        // throws 를 사용한 메소드를 호출 할 때에는 try - catch 문으로 묶어서 해당 예외를 처리하도록 만들어 주어야 한다
        // 또는, findClass 를 호출한 메소드도 throws 를 사용해야 한다.

        try {
            findClass();
        } catch (ClassNotFoundException e) {
            System.out.println("클래스가 존재하지 않습니다.");
        }

    }

    // throws ClassNotFoundException : Class...Exception 이 발생할 경우, findClass 를 호출한 곳에서 문제를 처리하도록 만들어준다.
    // throws 는 쉼표를 이용해서 여러개 만들 수 있다. (throws ClassNotFoundException, ArrayIndexOutOfBoundsException ...)
    public static void findClass() throws ClassNotFoundException {
        Class clazz = Class.forName("java.lang.String2");
    }
}
