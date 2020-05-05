package api_11.wrapper;

// 포장 클래스 타입에 기본값이 대입될 경우 자동으로 Boxing 이 일어난다.
// Integer obj = 100;   // 자동 Boxing
// 기본 타입에 포장 객체가 대입되는 경우 자동 UnBoxing 이 일어난다.
// int value = obj;     // 자동 UnBoxing

// 15장에서 학습할 Collection framework 객체에 int 값을 저장하면 자동 박싱이 일어난다.
// List<Integer> list = new ArrayList<Integer>();
// list.add(200);   // 자동 Boxing

public class AutoBoxingUnBoxingExample {
    public static void main(String[] args) {
        // 자동 Boxing
        Integer obj = 100;
        System.out.println("value : " + obj.intValue());

        // 대입 시 자동 UnBoxing
        int value = obj;
        System.out.println("value : " + value);

        // 연산 시 자동 UnBoxing
        int result = obj + 100;
        System.out.println("result : " + result);
    }
}
