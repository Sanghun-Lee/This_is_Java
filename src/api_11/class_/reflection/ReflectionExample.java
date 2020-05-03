package api_11.class_.reflection;

// Class 객체를 이용해서 클래스의 생성자, 필드, 메소드의 정보를 가져올 수 있다. 이른 Reflection 이라고 한다.
// return type  / method name    : explain
// Constructor[]    getDeclaredConstructors()   : 해당 클래스에 선언한 생성자들의 배열을 리턴한다.
// Field[]          getDeclaredFields()         : 해당 클래스에 선언한 필드들의 배열을 리턴한다.
// Method[]         getDeclaredMethods()        : 해당 클래스에 선언한 메소드들의 배열을 리턴한다.

// 위 3 메소드는 상속된 멤버는 가져오지 않는다.
// 상속된 멤보도 얻고 싶다면
// getFields()  / getMethods() 를 이용해야 한다. // but public 멤버만 가져온다.

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {
    public static void main(String[] args) {
        Class clazz = null;
        try {
            clazz = Class.forName("class_6.getter_setter.Car");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("[ 클래스 이름 ]");
        System.out.println(clazz.getName());
        System.out.println();

        // 생성자의 이름과 매개변수 정보들을 출력
        System.out.println("[ 생성자 정보 ]");
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for(Constructor constructor : constructors) {
            System.out.print(constructor.getName() + "(");          // 생성자 이름 출력
            Class[] parameters = constructor.getParameterTypes();   // 매개변수의 자료형을 배열로 만들어서 받는다.
            printParameters(parameters);                            // 매개변수들 출력
            System.out.println(")");
            System.out.println();
        }

        // 필드 타입과 필드 이름을 출력
        System.out.println("[ 필드 정보 ]");
        Field[] fields = clazz.getDeclaredFields();                 // 필드 변수들을 배열로 만들어서 받는다.
        for(Field field : fields) {
            System.out.println(field.getType().getSimpleName() + " " + field.getName());    // 필드들의 타입 이름과 필드 변수 이름을 얻어서 출력한다.
        }
        System.out.println();

        // 메소드 이름과 매개변수를 출력
        System.out.println("[ 메소드 정보 ]");
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods) {
            System.out.print(method.getReturnType().getSimpleName() + " ");   // 메소드의 리턴타입도 출력
            System.out.print(method.getName() + "(");               // 메소드 이름을 받아서 출력한다.
            Class[] parameters = method.getParameterTypes();
            printParameters(parameters);
            System.out.println(")");
        }
    }

    private static void printParameters(Class[] parameters) {
        for(int i = 0; i < parameters.length; i++) {
            System.out.print(parameters[i].getName());
            if(i < (parameters.length - 1)) {
                System.out.print(",");
            }
        }
    }
}
