package javafx_17.thread.service;

import javafx.concurrent.Service;
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

    private TimeService timeService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttonStart.setOnAction(this::handleStart);
        buttonStop.setOnAction(this::handleStop);
        timeService = new TimeService();
        timeService.start();        // start : Service 시작
    }

    public void handleStart(ActionEvent e) {
        timeService.restart();
        labelResult.setText("");
    }
    public void handleStop(ActionEvent e) {
        timeService.cancel();
    }

    class TimeService extends Service<Integer> {
        @Override
        protected Task<Integer> createTask() {
            Task<Integer> task = new Task<Integer>() {
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
                        }   // end of catch statement
                    }   // end of for loop
                    return result;
                }   // end of call method
            };  // end of Task class
            progressBar.progressProperty().bind(task.progressProperty());
            labelWorkDone.textProperty().bind(task.messageProperty());
            return task;
        }   // end of createTask

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
    }
}
