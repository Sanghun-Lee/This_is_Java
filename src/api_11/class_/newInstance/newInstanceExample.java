package api_11.class_.newInstance;

// newInstance : 프로그램 실행 중간에 객체를 생성할 수 있다.
// 실행전에 객체를 아는것이 아니라, 프로그램 실행 중간에 무슨 객체를 생성해야되는지 알게되는 경우
// newInstance 를 이용해서 실행중간에 객체를 생성할 수 있다.
// 그리고 이를 강제 형 변환으로 원하는 객체의 원하는 메소드를 실행시킬 수 있다.

// 그런데 무슨타입으로 강제 형 변환 할 것인가?
// 될 수 있는 경우들을 하나의 Interface 를 이용해서 구현하도록 한다.
// Interface 의 다형성을 이용해서 구현한다.


public class newInstanceExample {
    public static void main(String[] args) {
        try {
            // Class clazz = Class.forName("api_11.class_.newInstance.SendAction");
            Class clazz = Class.forName("api_11.class_.newInstance.ReceiveAction");
            // 다형성 이용
            Action action = (Action) clazz.newInstance();   // Object 를 Action 이라는 Interface type 으로 강제 형변환
            action.execute();
        } catch (ClassNotFoundException e) {        // forName 의 Exception 처리
            e.printStackTrace();
        } catch (InstantiationException e) {        // newInstance 의 Exception 처리 ...1
            e.printStackTrace();
        } catch (IllegalAccessException e) {        // newInstance 의 Exception 처리 ...2
            e.printStackTrace();
        }
    }
}
