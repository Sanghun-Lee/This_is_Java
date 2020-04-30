package interface_8.interface_;

public class Audio implements RemoteControl {
    // field
    private int volume;
    private boolean mute;

    // turnOn()
    @Override
    public void turnOn() {
        System.out.println("Audio를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("Audio를 끕니다.");
    }

    @Override
    public void setVolume(int volume) {
        if(volume > RemoteControl.MAX_VOLUME)
            this.volume = RemoteControl.MAX_VOLUME;
        else if(volume < RemoteControl.MIN_VOLUME)
            this.volume = RemoteControl.MIN_VOLUME;
        else
            this.volume = volume;

        System.out.println("현재 Audio 볼륨 : " + this.volume);
    }

    // RemoteControl interface 의 default method 인 setMute 를 Override 하였다.
    // 그래서 Audio 구현 객체를 가지고있는 RemoteControl 인터페이스 객체는 setMute를 호출하면 아래의 함수가 호출된다.
    @Override
    public void setMute(boolean mute) {
        this.mute = mute;
        if(mute) {
            System.out.println("Audio 무음 처리합니다.");
        }
        else {
            System.out.println("Audio 무음 해제합니다.");
        }
    }
    // default method 재정의
}
