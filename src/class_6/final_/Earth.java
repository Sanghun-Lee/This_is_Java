package class_6.final_;

public class Earth {
    // Java 상수 만들기
    // static final 키워드로 만들기
    // final 만으로는 객체마다 다른 값을 가질 수 있기 때문에 상수라 부르지 않는다.

    static final double EARTH_RADIUS = 6400;    // 선언과 동시에 초기화
    static final double EARTH_SURFACE_AREA;

    static {    // static 필드에서 static final변수를 초기화 할 수 있다.
        EARTH_SURFACE_AREA = 4 * Math.PI * EARTH_RADIUS * EARTH_RADIUS;
    }

    public static void main(String[] args) {
        System.out.println("지구의 반지름 : " + EARTH_RADIUS + " km");
        System.out.println("지구의 표면적 : " + EARTH_SURFACE_AREA + " km^2");
    }
}
