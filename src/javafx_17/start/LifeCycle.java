package javafx_17.start;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFx 라이프 사이클
 *
 * 시작 라이프 사이클
 * Application.launch() -> 해당 클래스 기본 생성자 -> init() -> start() -> UI 사용
 *
 * 종료 라이프 사이클
 * Platform.exit() 또는 마지막 Stage 닫힘 -> stop() -> 종료
 */

public class LifeCycle extends Application {
    public LifeCycle() {
        System.out.println(Thread.currentThread().getName() + " : LifeCycle() 호출");
    }

    @Override
    public void init() throws Exception {
        System.out.println(Thread.currentThread().getName() + " : init() 호출");
    }

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println(Thread.currentThread().getName() + " : start() 호출");
    }

    @Override
    public void stop() throws Exception {
        System.out.println(Thread.currentThread().getName() + " : stop() 호출");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " : main() 호출");
        launch(args);
    }
}
