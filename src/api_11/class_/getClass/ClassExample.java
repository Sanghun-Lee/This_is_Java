package api_11.class_.getClass;

// Class : class 의 정보를 가지고있는 메타 클래스이다.

// Class 객체를 얻기 위해선 Object 의 getClass() 메소드를 이용해야 한다.
// Class 는 생성자를 감추고 있기 때문에 new 연산자로 객체를 만들 수 없고,
// 정적 메소드인 forName()을 이용해야 한다.

import class_6.import_.com.Car;

public class ClassExample {
    public static void main(String[] args) {
        Car car = new Car();
        Class clazz1 = car.getClass();

        System.out.println(clazz1.getName());               // 클래스의 전체 이름
        System.out.println(clazz1.getSimpleName());         // 클래스의 간단한 이름
        System.out.println(clazz1.getPackage().getName());  // 패키지 이름 출력
        System.out.println();

        try {
            Class clazz2 = Class.forName("class_6.import_.com.Car");
            System.out.println(clazz2.getName());
            System.out.println(clazz2.getSimpleName());
            System.out.println(clazz2.getPackage().getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
