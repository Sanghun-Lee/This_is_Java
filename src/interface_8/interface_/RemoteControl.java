package interface_8.interface_;

// interface

public interface RemoteControl {
    // 상수만 선언가능 (static final), 안적을 시 자동으로 상수로 적힌다.
    public static final int MAX_VOLUME = 10;
    public static final int MIN_VOLUME = 0;

    // 추상 메소드
    public abstract void turnOn();
    public abstract void turnOff();
    public abstract void setVolume(int volume);

    // Default Method
    public default void setMute(boolean mute) {
        if(mute) {
            System.out.println("무음 처리합니다.");
        }
        else {
            System.out.println("무음 해제합니다.");
        }
    }

    public static void changeBattery() {
        System.out.println("건전지를 교체합니다.");
    }
}
