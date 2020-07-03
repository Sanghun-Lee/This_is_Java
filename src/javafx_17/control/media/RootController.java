package javafx_17.control.media;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {
    @FXML private MediaView mediaView;
    @FXML private ImageView imageView;
    @FXML private Button buttonPlay;
    @FXML private Button buttonStop;
    @FXML private Button buttonPause;

    private boolean endOfMedia;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // 미디어 객체 생성
        // Media media = new Media(getClass().getResource("media/video.m4v").toString();
        Media media = new Media(getClass().getResource("media/audio.wav").toString());

        // 미디어 플레이어 생성 및 미디어 뷰에 설정
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);

        // 해당 상태가 되면 실행할 Runnable 설정
        mediaPlayer.setOnReady(() -> {
            buttonPlay.setDisable(false);
            buttonStop.setDisable(true);
            buttonPause.setDisable(true);
        });

        mediaPlayer.setOnPlaying(() -> {
            buttonPlay.setDisable(true);
            buttonStop.setDisable(false);
            buttonPause.setDisable(false);
        });

        mediaPlayer.setOnEndOfMedia(() -> {
            endOfMedia = true;
            buttonPlay.setDisable(false);
            buttonStop.setDisable(true);
            buttonPause.setDisable(true);
        });

        mediaPlayer.setOnStopped(() -> {
            buttonPlay.setDisable(false);
            buttonStop.setDisable(true);
            buttonPause.setDisable(true);
        });

        // 버튼 ActionEvent 처리
        buttonPlay.setOnAction(event -> {
            if(endOfMedia) {
                mediaPlayer.stop();
                mediaPlayer.seek(mediaPlayer.getStartTime());
            }
            mediaPlayer.play();
            endOfMedia = false;
        });

        buttonPause.setOnAction(event -> mediaPlayer.pause());
        buttonStop.setOnAction(event -> mediaPlayer.stop());
    }
}
