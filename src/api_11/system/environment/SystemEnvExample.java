package api_11.system.environment;

// JAVA_HOME 환경변수 값 얻기
// String value = System.getenv(String name);

public class SystemEnvExample {
    public static void main(String[] args) {
        String javaHome = System.getenv("JAVA_HOME");
        System.out.println("JAVA_HOME : " + javaHome);
    }
}
