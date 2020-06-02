package generic_13.extends_;

public class BoundedTypeParameterExample {
    public static void main(String[] args) {
        // String str = Util.compare("a", "b"); // (x)
        // String 은 Number 를 상속받지 않기 때문에 사용할 수 없다.

        int result1 = Util.compare(10, 20); // int > Integer (자동 boxing)
        System.out.println(result1);

        int result2 = Util.compare(10.5, 5.3);  // double > Double 자동 boxing
        System.out.println(result2);
    }
}
