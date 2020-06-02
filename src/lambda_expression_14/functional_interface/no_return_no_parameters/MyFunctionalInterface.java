package lambda_expression_14.functional_interface.no_return_no_parameters;

@FunctionalInterface    // 위 어노테이션을 붙이면 해당 interface 가 두 개 이상의 추상메소드를 가지면 에러를 일으킨다.
public interface MyFunctionalInterface {
    public abstract void method();
}
