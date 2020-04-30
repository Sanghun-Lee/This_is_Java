package class_6.annotation;

/****** Annotation ******/
// 컴파일과정과 실행 과정에서 코드를어떻게 컴파일하고 처리할 것인지 알려주는 정보
// 1. 컴파일러에게 코드 문법 에러를 체크하도록 정보를 제공
// 2. 소프트웨어 개발 툴이 빌드나 배치 시 코드를 자동으로 생성할 수 있도록 정보를 제공
// 3. 실행 시(런타임 시) 특정 기능을 실행하도록 정보를 제공

// 참고 사이트 : https://elfinlas.github.io/2017/12/14/java-annotation/


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**** Annotation의 정의 ******/
// @Targer      : 해당 annotatino을 어디까지 적용할 수 있는지 정의하는 기능
// @Retention   : 해당 annoataion을 언제까지 유지할 것인지 정의한다. 일반적으론 RUNTIME으로 정의한다.
// Reflection을 이용해서 annotation이 무엇인지 알기 위해선 RUNTIME으로 설정해야 한다.
// RetentionPolicy 종류 : SOURCE, CLASS, RUNTIME

// @Target({ElementType.METHOD, ElementType.FIELD})     메서드와 필드위에서만 해당 annotation 을 쓸 수 있도록 정의
@Target({ElementType.METHOD})           // METHOD : 메서드 위에서만 해당 annotation 을 정의할 수 있다.
@Retention(RetentionPolicy.RUNTIME)     // RUNTIME : 컴파일 이후에도 annotation 정보를 사용할 수 있다.
public @interface PrintAnnotation {
    // Type elementName() [default value]; 로 정의한다.
    String value() default "-";     // String 타입에 기본값은 "-"인 value 이름의 element 멤버
    int number() default 15;        // int 타입에 기본값은 15인 number 이름의 element 멤버
}


// 그 외 기본적으로 지원하는 Annotation
// 1. @Override : 선언한 메서드가 override 되었다는 것을 나타낸다.
//                만약 상위(부모) 클래스에서 해당 메서드를 찾을 수 없으면 컴파일 에러를 발생시킨다.
//
// 2. @Deprecated : 해당 메서드가 더 이상 사용되지 않음을 표시한다.
//                  만약 사용할 경우 컴파일 경고를 발생시킨다.
//
// 3. @SuppressWarnings : 선언한 곳의 컴파일 경고를 무시하도록 한다.
// 4. @SafeVarargs : 제너릭 같은 가변인자의 매개변수를 사용할 때의 경고를 무시한다.
