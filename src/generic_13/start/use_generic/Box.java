package generic_13.start.use_generic;

// 일반적으로 <> 안에 T를 많이 넣어서 쓴다. <T>
// 아무 알파벳이나 넣어도 되는 것 같다.

public class Box<AA> {
    private AA t;
    public AA getT() {
        return this.t;
    }

    public void setT(AA t) {
        this.t = t;
    }
}
