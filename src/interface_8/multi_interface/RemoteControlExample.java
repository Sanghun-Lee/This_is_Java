package interface_8.multi_interface;

public class RemoteControlExample {
    public static void main(String[] args) {
        SmartTelevision tv = new SmartTelevision();

        // SmartTelevision 클래스는 RemoteControl, Searchable 둘 다 구현했기 때문에
        // 두 인터페이스 변수에 다 입력뒬 수 있다.
        RemoteControl remoteControl = tv;
        Searchable searchable = tv;

        // remoteControl 필드가 접근할 수 있는 메소드는 RemoteControl 인터페이스의 추상메소드만 접근할 수 있다.
        remoteControl.turnOn();
        remoteControl.setVolume(5);

        searchable.search("https://www.naver.com");
        remoteControl.turnOff();
    }
}
