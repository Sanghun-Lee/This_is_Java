package javafx_17.start;

import javafx.application.Application;
import javafx.stage.Stage;

public class AppMain extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.show();   // 윈도우 보여주기
    }

    public static void main(String[] args) {
        launch(args);   // AppMain 객체 생성 및 메인 윈도우 생성
    }
}
