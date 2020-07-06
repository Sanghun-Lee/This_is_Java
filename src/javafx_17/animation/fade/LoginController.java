package javafx_17.animation.fade;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

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
            root.getChildren().remove(login);   // StackPane 에서 login 제거
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
