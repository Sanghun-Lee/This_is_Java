package javafx_17.thread.run_later;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class RootController implements Initializable {
    @FXML private Label labelTime;
    @FXML private Button buttonStart;
    @FXML private Button buttonStop;

    private boolean stop;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttonStart.setOnAction(event -> handleButtonStart(event));
        buttonStop.setOnAction(this::handleButtonStop);
    }

    public void handleButtonStart(ActionEvent e) {
        stop = false;
        Thread thread = new Thread() {
            @Override
            public void run() {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                while(stop == false) {
                    String strTime = simpleDateFormat.format(new Date());
                    Platform.runLater(() -> {   // UI 변경 작업 요청
                        labelTime.setText(strTime);
                    });
                }
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
            }
        };

        thread.setDaemon(true);
        thread.start();     // thread 시작
    }
    public void handleButtonStop(ActionEvent e) {
        stop = true;
    }
}
