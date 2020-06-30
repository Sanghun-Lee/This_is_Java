package javafx_17.start;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * 무대(Stage)와 장면(Scene)
 *
 * 무대(Stage) : JavaFx의 윈도우
 * 장면(Scene) : 무대가 가질 수 있는 하나의 장면
 *
 * 실제로 JavaFx에선 Stage -> Scene -> Parent -> (Lable, Button...) 으로 이루어져 있다.
 */

public class StageAndScene extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();             // Parent 하위 객체인 VBox 생성
        root.setPrefWidth(350);             // VBox의 폭 설정
        root.setPrefHeight(150);            // VBox의 높이 설정
        root.setAlignment(Pos.CENTER);      // 컨트롤 (컴포넌트들)을 중앙으로 정렬
        root.setSpacing(20);                // 컨트롤 수직 간격

        Label label = new Label();          // Label 컨트롤 속성
        label.setText("Hello JavaFx");      // test 속성 설정
        label.setFont(new Font(50.0));   // font 속성 설정

        Button button = new Button();                   // 버튼 컨트롤 생성
        button.setText("확인");                          // text 속성 설정
        button.setOnAction(event -> Platform.exit());   // 클릭 이벤트 처리

        root.getChildren().add(label);      // VBox의 자식으로 Label 컨트롤 추가
        root.getChildren().add(button);     // VBox의 자식으로 Button 컨트롤 추가

        Scene scene = new Scene(root);      // VBox를 루트 컨테이너로 해서 Scene 생성

        stage.setTitle("AppMain");          // 윈도우의 제목 생성
        stage.setScene(scene);              // 윈도우에 장면 설정
        stage.show();                       // 윈도우 보여주기
    }

    public static void main(String[] args) {
        launch(args);
    }
}
