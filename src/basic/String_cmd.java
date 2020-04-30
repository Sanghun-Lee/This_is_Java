package basic;

public class String_cmd {
    public static void main(String[] args) {
        String str1 = "hun";
        String str2 = "hun";
        String str3 = new String(str1);

        System.out.println(str1 == str2);   // true
        System.out.println(str1 == str3);   // false
        System.out.println(str2 == str3);   // false
        System.out.println(str1.equals(str3));  // true

    }
}
