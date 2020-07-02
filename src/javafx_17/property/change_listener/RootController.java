package javafx_17.property.change_listener;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {
    @FXML private Slider slider;    // fxml의 fx:id와 값이 같아야 한다.
    @FXML private Label label;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                label.setFont(new Font(newValue.doubleValue()));
            }
        });
    }
}
