package inheritance_7.override;

public class ComputerExample {
    public static void main(String[] args) {
        int r = 10;
        Calculator calc = new Calculator();
        System.out.println("원 면적 : " + calc.areaCircle(r));

        Computer comp = new Computer();
        System.out.println("원 면적 : " + comp.areaCircle(r)); // 재 정의된 메서드 호출

        System.out.println("Calculator와 Computer의 값의 차이 : " + comp.compare(r));
    }
}
