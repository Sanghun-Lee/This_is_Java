package javafx_17.event.fxml;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {
    @FXML private Button button1;
    @FXML private Button button2;
    @FXML private Button button3;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handleButton1Action(actionEvent);
            }
        });

        button2.setOnAction(event -> handleButton2Action(event));
        button3.setOnAction(this::handleButton3Action);

    }

    public void handleButton1Action(ActionEvent event) {
        System.out.println("버튼1 클랙");
    }

    public void handleButton2Action(ActionEvent event) {
        System.out.println("버튼2 클랙");
    }

    public void handleButton3Action(ActionEvent event) {
        System.out.println("버튼3 클랙");
    }
}
