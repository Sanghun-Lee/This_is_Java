package inheritance_7.abstract_.override;

public abstract class Animal {
    public String kind;

    public void breathe() {
        System.out.println("숨을 쉽니다.");
    }

    // 추상 메소드    // 메소드 이름만 동일하고 내용을 다르게 만들어야 할 때 추상메소드를 만든다.
    // 추상클래스를 상속받은 클래스는 추상메소드 모두 Override 해야한다.
    public abstract void sound();
}
