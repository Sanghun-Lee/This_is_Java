package collection_framework_15.map.hash_table;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

// hashmap이랑 똑같고, 스레드가 안전한 것 말고는 다른게 없다.
// 모두 동기화된 메소드를 사용한다.

public class HashtableExample {
    public static void main(String[] args) {
        Map<String, String> map = new Hashtable<>();

        map.put("spring", "12");
        map.put("summer", "123");
        map.put("fall", "1234");
        map.put("winter", "12345");

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("아이디와 비밀번호를 입력해 주세요");
            System.out.print("아이디 : ");
            String id = scanner.nextLine();

            System.out.print("비밀번호 : ");
            String password = scanner.nextLine();
            System.out.println();

            if(map.containsKey(id)) {
                if(map.get(id).equals(password)) {
                    System.out.println("로그인 되었습니다.");
                    break;
                }
                else {
                    System.out.println("비밀번호가 일치하지 않습니다.");
                }
            }
            else {
                System.out.println("입력하신 아이디가 존재하지 않습니다.");
            }
        }
    }
}
