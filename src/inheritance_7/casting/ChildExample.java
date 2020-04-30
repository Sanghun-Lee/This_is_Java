package inheritance_7.casting;

/***    강제 타입 변환(캐스팅)    ***/

public class ChildExample {
    public static void main(String[] args) {
        Parent parent = new Child();        // 자동 타입 변환
        parent.field1 = "data1";
        parent.method1();
        parent.method2();

        // parents.field2 = "data2";        // 불가능하다.
        // parents.method3();               // 이것도 불가능하다.

        // 강제 타입 변환 (캐스팅)은 자식 타입이 부모 타입으로 자동 타입 변환이 일어난 상태에서만 가능하다.
        // 자식 타입이 부모 타입으로 자동 타입 변환이 일어났는지 확인하는 방법 : instanceof
        Child child = (Child)parent;        // 강제 타입 변환
        child.field2 = "yyy";               // 가능하다.
        child.method3();                    // 이것도 가능하다.
    }
}
