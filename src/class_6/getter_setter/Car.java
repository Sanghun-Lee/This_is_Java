package class_6.getter_setter;

public class Car {
    /***** Getter, Setter *******/
    // class에서 field는 private으로 보호해 주어야 한다.
    // 그리고 getter와 setter를 만들어서 메서드를 통해서 값을 저장하거나, 불러와야 한다.

    // getter, setter 명명규칙 (관례)
    // boolean type : getter : is + 변수명 (첫 문자 대문자), setter : set + 변수명 (첫 문자 대문자)
    // others : get + 변수명 (첫 문자 대문자), setter : set + 변수명 (첫 문자 대문자)

    // field
    private int speed;
    private boolean stop;

    // constructor

    // method
    public int getSpeed() {
        return speed;
    }

    // getter setter를 통해서 검증된 값만 필드에 저장할 수 있다.
    public void setSpeed(int speed) {
        if(speed < 0) {
            this.speed = 0;
            return;
        }
        else
            this.speed = speed;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
        this.speed = 0;
    }
}
