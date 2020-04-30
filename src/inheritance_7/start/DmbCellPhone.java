package inheritance_7.start;

// CellPhone 을 상속받는다.
public class DmbCellPhone extends CellPhone {
    // field
    int channel;

    // constructor
    // 자식객체가 생성될 때 부모객체도 생성된다. 부모객체는 생성자를 이용해서 생성된다.
    // 생성자에 임의로 작성해주지 않았으면 super(); 가 자동으로 추가된다.
    DmbCellPhone(String model, String color, int channel) {
        // super();         // 자동으로 추가되고, 이는 부모생성자를 생성한다.
        this.model = model;     // CellPhone 으로 부터 상속받은 필드
        this.color = color;     // CellPhone 으로 부터 상속받은 필드
        this.channel = channel;
    }

    // method
    void turnOnDmb() {
        System.out.println("채널 : " + channel + "번 DMB 방송을 수신합니다.");
    }
    void changeChannelDmb(int channel) {
        this.channel = channel;
        System.out.println("채널 : " + channel + "번으로 바꿉니다.");
    }
    void turnOffDmb() {
        System.out.println("DMB 방송 수신을 멈춥니다.");
    }
}
