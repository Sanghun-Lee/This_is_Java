package class_6.method;

public class ComputerExample {
    public static void main(String[] args) {
        Computer myCom = new Computer();

        int[] values1 = { 1, 2, 3};
        int result1= myCom.sum1(values1);
        System.out.println("result1 : " + result1);

        // 배열을 이용해서 전달하는 것이기 때문에 배열을 생성해서 매개변수로 넘겨준다.
        int result2 = myCom.sum1(new int[] {1, 2, 3, 4, 5});
        System.out.println("result2 : " + result2);

        // "..."연산자를 사용할 경우 괄호안에 들어갈 매개변수를 바로 전달하면 된다.
        int result3 = myCom.sum2(1, 2, 3);
        System.out.println("result3 : " + result3);

        int result4 = myCom.sum2(1, 2, 3, 4, 5, 6, 7);
        System.out.println("result4 : " + result4);

    }
}
