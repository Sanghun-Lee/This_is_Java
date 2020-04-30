package interface_8.interface_;

// 구현 클래스
// interface 를 구현한 클래스라고 해서 클래스이름옆에 implements 를 작성한다.
// Override 된 메서드들은 무조건 public이어야 한다 (인터페이스에서 모두 public 이었기 때문에)
public class Television implements RemoteControl{
    private int volume;

    // turnOn() 메소드의 실체 메소드
    @Override
    public void turnOn() {
        System.out.println("텔레비젼을 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("텔레비젼을 끕니다.");
    }

    @Override
    public void setVolume(int volume) {
        if(volume > RemoteControl.MAX_VOLUME)
            this.volume = RemoteControl.MAX_VOLUME;
        else if(volume < RemoteControl.MIN_VOLUME)
            this.volume = RemoteControl.MIN_VOLUME;
        else
            this.volume = volume;

        System.out.println("현재 TV 볼륨 : " + this.volume);
    }
}
