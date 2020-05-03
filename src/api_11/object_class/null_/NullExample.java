package api_11.object_class.null_;

// 널 여부 조사(isNull(), nonNull(), requireNonNull())
// isNull   : Objects.isNull(Object obj)    - obj 가 null 이면 true, null 이 아니면 false
// nonNull  : Objects.nonNull(Object obj)   - obj 가 null 이면 false, null 이 아니면 true
// requireNonNull : Objects.requireNonNull(Object obj)  - nonNull 이면 return obj, null 이면 NullPointException 발생

import java.util.Objects;

public class NullExample {
    public static void main(String[] args) {
        String str1 = "홍길동";
        String str2 = null;

        System.out.println(Objects.requireNonNull(str1));

        try {
            String name = Objects.requireNonNull(str2);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            String name = Objects.requireNonNull(str2, "이름이 없습니다.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            String name = Objects.requireNonNull(str2, () -> "이름이 없다니까요");  // 람다식
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
