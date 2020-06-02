package generic_13.multi_type;

// 제네릭 타입은 두 개 이상의 멀티 타입 파라미터를 사용할 수 있다.
// 이 경우 콤마로 구분한다.

public class ProductExample {
    public static void main(String[] args) {
        Product<Tv, String> product1 = new Product<Tv, String>();
        product1.setKind(new Tv());
        product1.setModel("스마트 Tv");
        Tv tv = product1.getKind();
        String model = product1.getModel();

        Product<Car, String> product2 = new Product<>();    // 이렇게 생성자에서 <> 내부를 생략할 수 있다.
        product2.setKind(new Car());
        product2.setModel("디젤");
        Car car = product2.getKind();
        String model2 = product2.getModel();
    }
}

class Tv {

}

class Car {

}
