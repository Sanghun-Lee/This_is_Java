package generic_13.generic_extends;

// 제네릭타입을 가진 부모를 상속받는 자식 클래스
// 부모가 제네릭 타입이면 자식도 해당 제네릭 타입을 가져야 한다. (더 가져도 상관없다)

public class ChildProduct<T, M, C> extends Product<T, M> {
    private C company;

    public C getCompany() {
        return company;
    }

    public void setCompany(C company) {
        this.company = company;
    }
}
