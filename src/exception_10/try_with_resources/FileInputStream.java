package exception_10.try_with_resources;

// 자동 리소스 닫기
// AutoCloseable 인터페이스를 받고, close() 메소드를 Override 하면
// main 의 try 에서 예외가 발생할 경우 Override 한 close 메소드를 호출한다.
// 그래서 close 메소드에서 파일 입출력에 관한 리소스를 close 하면 Exception 이 발생했을 때 자동으로 resource 를 닫아 줄 수 있다.

public class FileInputStream implements AutoCloseable {
    private String file;

    public FileInputStream(String file) {
        this.file = file;
    }

    public void read() {
        System.out.println(file + "을 읽습니다.");
    }

    @Override
    public void close() throws Exception {
        System.out.println(file + "을 닫습니다.");
    }
}
