package javafx_17.animation.fade;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

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
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
