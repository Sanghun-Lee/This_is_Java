package class_6.import_.com;

import class_6.import_.com.hankook.*;
import class_6.import_.com.kumho.*;

public class Car {
    public static void main(String[] args) {
        // 다른 패키지의 클래스의 객체를 생성하는 방법
        // 해당 클래스의 패키지를 모두 작성하면 된다.
        class_6.import_.com.hankook.Tire Tire = new class_6.import_.com.hankook.Tire();

        // 다른 방법
        // import문을 이용한다
        // 3번줄 처럼 import문을 작성한다.
        // 그리고 아래와같이 클래스를 생성한다.
        SnowTire snow_tire = new SnowTire();

        // hankook과 kumho 둘 다 Tire class가 있기 때문에 Tire를 선언하려면 package 모두 적어야 한다.
        class_6.import_.com.hankook.Tire hankook_tire = new class_6.import_.com.hankook.Tire();
        class_6.import_.com.kumho.Tire kumho_tire = new class_6.import_.com.kumho.Tire();
    }
}
