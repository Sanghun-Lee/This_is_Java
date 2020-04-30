package class_6.annotation;

import java.lang.reflect.Method;

public class PrintAnnotationExample {
    public static void main(String[] args) {
        // Service 클래스로부터 메소드 정보를 얻는다.
        Method[] declaredMethod = Service.class.getDeclaredMethods();   // Service class에 선언된 모든 메소드 얻기 (리플렉션)
        // Field는           return type : Filed[],          메소드 명 : getFields();
        // Constructor는     return type : Constructor[],    메소드 명 : getConstructors()
        // Method는          return type : Method[],         메소드 명 : getDeclaredMethods()

        // 위와같이 호출하면 declaredMethod[0] = method_name1, [1] = method_name2, [2] = method_name3이 된다. >> 메서드 이름이 들어간다.
        // 배열로 리턴된다.

        /******
        Annotation 정보를 얻는 함수
        1. boolean isAnnotationPresent(Class<? extends Annotation> annotationClass)    : 지정한 annotation이 적용되었는지 여부를 확인
        2. Annotation getAnnotation(Class<T> annotationClass)   : 지정한 annotation이 있으면 annotation을 리턴한다. 없으면 null
        3. Annotation[] getAnnotations()            : 적용된 모든 annotation을 리턴한다. annotation이 없으면 길이가 0인 배열을 리턴
        4. Annotation[] getDeclaredAnnotation()     : 직접 적용된 모든 annotation을 리턴한다. 상위 클래스에 적용된 annotation은 포함하지 않는다.
        ******/

        // Method 객체를 하나씩 처리
        for(Method method : declaredMethod) {
            // PrintAnnotation 이 적용되었는지 확인 (isAnnotationPresent(Annotation 이름.class) 함수로 확인한다.)
            if(method.isAnnotationPresent(PrintAnnotation.class)) {
                // PrintAnnotation 객체 얻기
                PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class);

                // 메소드 이름 출력
                System.out.println("[" + method.getName() + "]");
                // 구분선 출력
                for(int i = 0; i < printAnnotation.number(); i++) {
                    System.out.print(printAnnotation.value());
                }
                System.out.println();
            }

            try {
                // 메소드 호출, method_name4는 annotation이 없기 때문에 위 if문에서 false가 되고, 메서드 실행만 되고 끝난다.
                method.invoke(new Service());
            } catch (Exception e) {}
            System.out.println();
        }
    }
}
