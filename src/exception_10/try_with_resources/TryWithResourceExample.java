package exception_10.try_with_resources;

public class TryWithResourceExample {
    public static void main(String[] args) {
        // Try with resource
        try (FileInputStream fis = new FileInputStream("file.txt")) {
            fis.read();
            throw new Exception();  // 강제적으로 예외를 발생시킨다.
            // 예외가 발생하면 FileInputStream class 에서 Override 된 close 메소드를 실행한다.
        } catch (Exception e) { // 그리고 catch 문도 실행된다.
            System.out.println("예외 처리 코드가 실행되었습니다.");
        }
    }
}
