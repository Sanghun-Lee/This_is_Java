package javafx_17.thread.task.callback;

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
    @FXML private Label labelResult;
    @FXML private Button buttonStart;
    @FXML private Button buttonStop;

    private Task<Integer> task;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttonStart.setOnAction(this::handleButtonStart);
        buttonStop.setOnAction(this::handleButtonStop);
    }

    public void handleButtonStart(ActionEvent e) {
        task = new Task<Integer>() {
            @Override
            protected Integer call() throws Exception {
                int result = 0;
                for(int i = 0; i <= 100; i++) {
                    if(isCancelled()) { break; }
                    result += i;
                    updateProgress(i, 100);
                    updateMessage(String.valueOf(i));
                    try { Thread.sleep(100); } catch (InterruptedException e) {
                        if(isCancelled()) { break; }
                    }
                }
                return result;
            }

            // task가 성공적으로 마쳤을 시 실행
            // JavaFx Application Thread에서 실행되서 UI 변경 가능
            @Override
            protected void succeeded() {
                labelResult.setText(String.valueOf(getValue()));
            }

            @Override
            protected void cancelled() {
                labelResult.setText("취소됨");
            }

            @Override
            protected void failed() {
                labelResult.setText("실패");
            }
        };

        progressBar.progressProperty().bind(task.progressProperty());
        labelWorkDone.textProperty().bind(task.messageProperty());
        labelResult.setText("");

        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }
    public void handleButtonStop(ActionEvent e) {
        task.cancel();
    }
}
