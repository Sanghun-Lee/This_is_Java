package api_11.system.garbageCollector;

public class GcExample {
    public static void main(String[] args) {
        Employee emp;

        emp = new Employee(1);  // 쓰래기가 되었다.
        emp = null;                 // 윗 줄의 객체가 쓰래기가 되었다.
        emp = new Employee(3);
        emp = null;                 // 윗 줄의 객체가 쓰래기가 되었다.
        emp = new Employee(5);

        System.out.print("emp 가 최정적으로 참조하는 사원번호 : ");
        System.out.println(emp.eno);
        System.gc();        // 쓰래기 수집기 실행요청
    }
}


class Employee {
    public int eno;

    public Employee(int eno) {
        this.eno = eno;
        System.out.println("Employee(" + eno + ") 가 메모리에 생성됨");
    }

    @Override   // 소멸자
    public void finalize() {
        System.out.println("Employee(" + eno + ") 가 메모리에 제거됨");
    }
}