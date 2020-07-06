package javafx_17.animation.slide;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML private BorderPane login;
    @FXML private Button buttonMain;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttonMain.setOnAction(this::handleButtonMain);
    }

    public void handleButtonMain(ActionEvent event) {
        try {
            StackPane root = (StackPane) buttonMain.getScene().getRoot();
            // root.getChildren().remove(login);   // StackPane 에서 login 제거

            login.setTranslateX(0); // 시작값을 0으로 설정

            Timeline timeline = new Timeline();
            KeyValue keyValue = new KeyValue(login.translateXProperty(), 350);
            KeyFrame keyFrame = new KeyFrame(
                    Duration.millis(100),
                    event1 -> root.getChildren().remove(login), // 람다식으로 처리, 애니메이션 종료 후, 해당 메소드 실행
                    keyValue
                    );

            timeline.getKeyFrames().add(keyFrame);
            timeline.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
