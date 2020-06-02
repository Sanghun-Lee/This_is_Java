package lambda_expression_14.functional_interface.return_and_parameters;

@FunctionalInterface    // 해당 어노테이션을 붙이면 추상 메소드가 2개 이상 시에 에러를 일으킨다.
public interface MyFunctionalInterface {
    public abstract int method(int x, int y);
}
