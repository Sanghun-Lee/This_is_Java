package javafx_17.layout.fxml.start;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Program_Layout extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        HBox hBox = new HBox();     // HBox 컨테이너 생성
        hBox.setPadding(new Insets(10));    // 안쪽 여백 설정
        hBox.setSpacing(10);        // 컨트롤 칸의 수평 간격 설정

        TextField textField = new TextField();  // TextField 컨트롤 생성
        textField.setPrefWidth(200);    // TextField의 폭 설정

        Button button = new Button();   // Button 컨트롤 생성
        button.setText("확인");           // Button 글자 설정

        ObservableList list = hBox.getChildren();   // HBox의 ObservableList 열기
        list.add(textField);    // TextField 컨트롤 배치
        list.add(button);       // Button 컨트롤 배치

        Scene scene = new Scene(hBox);  // 장면 생성

        stage.setScene(scene);
        stage.setTitle("AppMain");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
