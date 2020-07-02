package javafx_17.property.binding.operation;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {
    @FXML private AnchorPane root;
    @FXML private Circle circle;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        circle.centerXProperty().bind(Bindings.divide(root.widthProperty(), 2));
        circle.centerYProperty().bind(Bindings.divide(root.heightProperty(), 2));
    }
}
