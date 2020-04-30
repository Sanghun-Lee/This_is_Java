package class_6.final_;

public class Person {
    /**** Final ****/
    // final변수는 해당 변수에 초기값이 저장되면 최종적인 값이 되어서 프로그램 실행 도중에 수정할 수 없다.
    // final 변수는 선언과 동시에 초기화 or 생성자에서 초기화 이 두 가지로 밖에 초기화 할 수 밖에 없다.

    final String nation = "Korea";  // nation변수의 값은 Korea로 고정되고, nation변수를 수정하면 에러를 일으킨다.
    final String ssn;   // 생성자에서 초기화 할 수 있다. 초기화 하지 않으면 에러를 일으킨다.
    String name;

    public Person(String ssn, String name) {
        this.ssn = ssn; // 생성자에서 final변수를 초기화 할 수 있다.
        this.name = name;
    }
}
