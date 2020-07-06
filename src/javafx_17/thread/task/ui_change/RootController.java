package javafx_17.thread.task.ui_change;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.net.URL;
import java.util.ResourceBundle;


public class RootController implements Initializable {
    @FXML private ProgressBar progressBar;
    @FXML private Label labelWorkDone;
    @FXML private Button buttonStart;
    @FXML private Button buttonStop;

    private Task<Void> task;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttonStart.setOnAction(this::handleButtonStart);
        buttonStop.setOnAction(this::handleButtonStop);
    }

    public void handleButtonStart(ActionEvent e) {
        task = new Task<Void>() {   // Task가 @FunctionalInterface가 아니라서 람다식으론 안된다.
            @Override
            protected Void call() throws Exception {
                for(int i = 1; i <= 100; i++) {
                    if(isCancelled()) {
                        updateMessage("취소됨");
                        break;
                    }
                    updateProgress(i, 100);
                    updateMessage(String.valueOf(i));
                    try { Thread.sleep(100); } catch (InterruptedException e) {
                        if(isCancelled()) {
                            updateMessage("취소됨");
                            break;
                        }
                    }
                }
                return null;
            }
        };  // 여기까지 Task 정의

        progressBar.progressProperty().bind(task.progressProperty());
        labelWorkDone.textProperty().bind(task.messageProperty());

        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }
    public void handleButtonStop(ActionEvent e) {
        task.cancel();
    }
}
