package api_11.toString;

public class SmartPhoneExample {
    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone("구글", "안드로이드");

        String strObj = myPhone.toString();
        System.out.println(strObj);

        // myPhone.toString() 을 자동 호출해서 리턴값을 얻은 후 출력한다.
        System.out.println(myPhone);
        // System.out.println() 에게 객체를 그대로 전달해주면 객체의 toString() 메소르를 호출해서
        // 리턴값을 받아서 출력하도록 한다.
    }
}
