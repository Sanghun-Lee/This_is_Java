package javafx_17.property.binding;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {
    @FXML private TextArea textArea1;
    @FXML private TextArea textArea2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Bindings.bindBidirectional(textArea1.textProperty(), textArea2.textProperty());
    }
}
