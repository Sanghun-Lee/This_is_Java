package inheritance_7.abstract_.override;

public class AnimalExample {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        dog.sound();
        cat.sound();
        System.out.println("-------------");

        // 변수 자동 타입 변환
        Animal animal = null;
        animal = new Dog();     // 자동 타입 변환
        animal.sound();         // 재정의된 메서드 호출
        // 자동 타입 변환이 되었고, 자식객체에서 Override 된 메서드면 Override 된 메소드가 호출된다.

        animal = new Cat();
        animal.sound();
        System.out.println("-------------");

        // 메소드의 다형성
        animalSound(new Dog());
        animalSound(new Cat());
    }

    public static void animalSound(Animal animal) {
        animal.sound();
    }
}
