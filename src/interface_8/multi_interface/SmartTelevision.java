package interface_8.multi_interface;

public class SmartTelevision implements RemoteControl, Searchable {
    // 두 개의 interface 를 모두 받았다면 두 interface 에 있는 추상메서드를 모두 구현해 주어야 한다.
    private int volume;

    @Override
    public void turnOn() {
        System.out.println("TV를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("TV를 끕니다.");
    }

    @Override
    public void setVolume(int volume) {
        if(volume > interface_8.interface_.RemoteControl.MAX_VOLUME)
            this.volume = interface_8.interface_.RemoteControl.MAX_VOLUME;
        else if(volume < interface_8.interface_.RemoteControl.MIN_VOLUME)
            this.volume = interface_8.interface_.RemoteControl.MIN_VOLUME;
        else
            this.volume = volume;
    }
    //// 여기까지 RemoteControl의 추상 메소드에 대한 실체 메소드

    @Override
    public void search(String url) {
        System.out.println(url + "을 검색합니다.");
    }
    // Searchable interface 의 추상메소드를 구현한 실체 메소드
}
