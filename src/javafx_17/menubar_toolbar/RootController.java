package javafx_17.menubar_toolbar;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {
    @FXML private TextArea textArea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void handleNew(ActionEvent e) {
        textArea.appendText("New\n");
    }

    public void handleOpen(ActionEvent e) {
        textArea.appendText("Open\n");
    }

    public void handleSave(ActionEvent e) {
        textArea.appendText("Save\n");
    }

    public void handleExit(ActionEvent e) {
        Platform.exit();
    }
}
