package javafx_17.dialog.custom;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AppMain_dialog extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Stage dialog = new Stage(StageStyle.UTILITY);
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.initOwner(stage);
        dialog.setTitle("확인");

        Parent root = FXMLLoader.load(getClass().getResource("custom_dialog.fxml"));

        // 메시지 설정
        Label label = (Label) root.lookup("#textTitle");
        label.setText("확인하셨습니까?");

        // 버튼 설정
        Button buttonOk = (Button) root.lookup("#buttonOk");
        buttonOk.setOnAction(event -> dialog.close());

        Scene scene = new Scene(root);  // Scene 설정

        dialog.setScene(scene);         // 다이얼로그에 Scene 설정
        dialog.setResizable(false);     // 크기변경 불가
        dialog.show();                  // 다이얼로그 띄우기
    }

    public static void main(String[] args) {
        launch(args);
    }
}
