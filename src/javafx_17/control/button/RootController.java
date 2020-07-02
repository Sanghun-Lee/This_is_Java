package javafx_17.control.button;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {
    @FXML private CheckBox check1;
    @FXML private CheckBox check2;
    @FXML private ImageView checkImageView;
    @FXML private ToggleGroup group;
    @FXML private ImageView radioImageView;
    @FXML private Button buttonExit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldValue, Toggle newValue) {
                Image image = new Image(getClass().getResource("images/" + newValue.getUserData().toString() + ".png").toString());
                radioImageView.setImage(image);
            }
        });
    }

    public void handleCheckAction(ActionEvent e) {
        if(check1.isSelected() && check2.isSelected()) {
            checkImageView.setImage(new Image(getClass().getResource("images/geek-glasses-hair.gif").toString()));
        } else if(check1.isSelected()) {
            checkImageView.setImage(new Image(getClass().getResource("images/geek-glasses.gif").toString()));
        } else if(check2.isSelected()) {
            checkImageView.setImage(new Image(getClass().getResource("images/geek-hair.gif").toString()));
        } else {
            checkImageView.setImage(new Image(getClass().getResource("images/geek.gif").toString()));
        }
    }

    public void handleButtonExitAction(ActionEvent e) {
        Platform.exit();
    }
}
