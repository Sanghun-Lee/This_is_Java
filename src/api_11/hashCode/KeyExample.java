package api_11.hashCode;

import java.util.HashMap;

// HashMap 의 경우 hashCode() 메소드를 실행해서 리턴된 해시코드 값이 같은지를 확인하고,
// equals() 메소드를 실행해서 return 값이 같으면 같은 객체로 판단한다.

public class KeyExample {
    public static void main(String[] args) {
        // Key 객체를 식별키로 사용해서 String 값을 저장하는 HashMap 객체 생성
        HashMap<Key, String> hashMap = new HashMap<Key, String>();

        // 식별키 "new Key(1)"로 "홍길동"을 저장함
        hashMap.put(new Key(1), "홍길동");         // ....1

        // 식별키 "new Key(1)"로 "홍길동"을 읽어옴
        String value = hashMap.get(new Key(1)); // ....2

        // 기존에는 Key에서 hashCode()함수를 Override 하지 않아서 위와 같이 HashMap에서 데이터를 찾으면
        // hashCode() 메소드에서 리턴하는 해시코드가 다르기 때문에 다른 식별키로 인식해서 value 에는 null 값이 오게된다.
        // 1번에서 데이터를 저장하는데 사용한 Key 객체와 2번에서 데이터를 불러오기 위해 사용한 Key 객체가 다르기때문에 value 에 null 이 들어간다.
        // 1번의 Key 객체와 2번의 Key 객체가 같은지 확인하는 메소드가 hashCode() 메소드 이다.
        // 그래서 의도한 대로 읽기 위해선 Key 클래스에서 hashCode() 메소드를 Override 해야한다.

        // 실제로 1번과 2번의 Key 객체는 다른 값이지만,
        // Key 클래스에서 hashCode() 메소드를 Override 해서 1번과 2번에 대해 hashCode() 메소드도 true 를 return 하고,
        // equals 메소드도 true 를 리턴하게 만들어서 value 에 원하는 값이 오도록 만든다.

        System.out.println(value);

    }
}
