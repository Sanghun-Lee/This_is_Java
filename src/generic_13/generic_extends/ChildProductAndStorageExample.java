package generic_13.generic_extends;

public class ChildProductAndStorageExample {
    public static void main(String[] args) {
        ChildProduct<Tv, String, String> product = new ChildProduct<>();
        product.setKind(new Tv());
        product.setModel("smartTv");
        product.setCompany("Samsung");

        Storage<Tv> storage = new StorageImpl<>(100);
        storage.add(new Tv(), 0);
        Tv tv = storage.get(0);
    }
}
