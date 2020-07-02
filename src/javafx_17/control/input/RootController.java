package javafx_17.control.input;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class RootController implements Initializable {
    @FXML private TextField textTitle;
    @FXML private PasswordField textPassword;
    @FXML private ComboBox<String> comboPublic;
    @FXML private DatePicker dateExit;
    @FXML private TextArea textContent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void handleButtonRegisterAction(ActionEvent e) {
        String title = textTitle.getText();
        System.out.println("text : " + title);

        String password = textPassword.getText();
        System.out.println("password : " + password);

        String strPublic = comboPublic.getValue();
        System.out.println("public : " + strPublic);

        LocalDate localDate = dateExit.getValue();
        if(localDate != null) {
            System.out.println("dateExit : " + localDate.toString());
        }

        String content = textContent.getText();
        System.out.println("content : " + content);
    }

    public void handleButtonCancelAction(ActionEvent e) {
        Platform.exit();
    }
}
