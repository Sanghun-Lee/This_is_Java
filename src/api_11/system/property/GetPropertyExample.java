package api_11.system.property;

// 시스템 관련 설정 읽어오기
// Key, value 쌍으로 이루어져 있다.
// String value = System.getProperty(String key);

// java.version     : 자바의 버전
// java.home        : 사용하는 JRE 파일의 경로
// os.name          : 운영체제 이름
// user.name        : 사용자 이름
// user.home        : 사용자의 홈 디렉토리
// user.dir         : 사용자가 현재 작업 중인 디렉토리 경로

import java.util.Properties;
import java.util.Set;

public class GetPropertyExample {
    public static void main(String[] args) {
        String osName = System.getProperty("os.name");
        String userName = System.getProperty("user.name");
        String userHome = System.getProperty("user.home");

        System.out.println("운영체제 이름 : " + osName);
        System.out.println("사용자 이름 : " + userName);
        System.out.println("사용자 홈 디렉토리 : " + userHome);

        System.out.println("--------------------------------");
        System.out.println(" [ key ] value ");
        System.out.println("--------------------------------");

        // Properties 가 가지고있는 모든 시스템 속성들을 출력
        Properties properties = System.getProperties();
        Set keys = properties.keySet();
        for(Object objKey : keys) {
            String key = (String) objKey;
            String value = System.getProperty(key);
            System.out.println("[ " + key + " ] " + value);
        }
    }
}
