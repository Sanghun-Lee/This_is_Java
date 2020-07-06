package javafx_17.animation.slide;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {
    @FXML private Button buttonLogin;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttonLogin.setOnAction(this::handleButtonLogin);
    }

    public void handleButtonLogin(ActionEvent e) {
        try {
            Parent login = FXMLLoader.load(getClass().getResource("login.fxml"));
            // getRoot : Parent 전달
            // getWindow : Stage 전달
            StackPane root = (StackPane) buttonLogin.getScene().getRoot();
            root.getChildren().add(login);

            login.setTranslateX(350);   // 시작값을 350으로 지정 (로그인 화면의 폭)

            Timeline timeline = new Timeline();
            KeyValue keyValue = new KeyValue(login.translateXProperty(), 0);    // 종료값을 0으로 설정
            KeyFrame keyFrame = new KeyFrame(Duration.millis(100), keyValue);      // 0.1초간 지속
            timeline.getKeyFrames().add(keyFrame);
            timeline.play();

            // 아래와 같이 애니메이션이 끝나고 난 후, 콜백 메소드를 정의할 수 있다.
            /*
            KeyFrame keyFrame = new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    // 애니메이션이 종료된 후 실행할 메소드
                }
            }, keyValue);
            */

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
