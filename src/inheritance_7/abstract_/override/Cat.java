package inheritance_7.abstract_.override;

public class Cat extends Animal {
    public Cat() {
        this.kind = "포율류";
    }

    @Override
    public void sound() {
        System.out.println("냐옹");
    }
}
