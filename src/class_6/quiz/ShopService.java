package class_6.quiz;

public class ShopService {
    private ShopService() {}
    static ShopService sc = new ShopService();

    public static ShopService getInstance() {
        return sc;
    }
}
