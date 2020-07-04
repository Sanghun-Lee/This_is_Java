package javafx_17.dialog;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.*;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    // 파일 열기 다이얼로그 실행
    public void handleOpenFileChooser(ActionEvent e) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );
        File selectedFile = fileChooser.showOpenDialog(primaryStage);   // modal 창 open
        if(selectedFile != null) {
            System.out.println(selectedFile.getPath());
        }
    }

    // 파일 저장 다이얼로그 실행
    public void handleSaveFileChooser(ActionEvent e) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("All Files", "*.*"));
        File selectedFile = fileChooser.showSaveDialog(primaryStage);   // modal 창 open
        if(selectedFile != null) {
            System.out.println(selectedFile.getPath());
        }
    }

    // 디렉토리 선택 다이얼로그 실행
    public void handleDirectoryChooser(ActionEvent e) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(primaryStage); // modal 창 open
        if(selectedDirectory != null) {
            System.out.println(selectedDirectory.getPath());
        }
    }

    // Popup 다이얼로그 실행
    public void handlePopup(ActionEvent e) throws Exception {
        Popup popup = new Popup();

        HBox hBox = (HBox) FXMLLoader.load(getClass().getResource("popup/popup.fxml"));
        ImageView imageView = (ImageView) hBox.lookup("#imageMessage");
        imageView.setImage(new Image(getClass().getResource("images/dialog-info.png").toString()));
        imageView.setOnMouseClicked(mouseEvent -> popup.hide());
        Label label = (Label) hBox.lookup("#labelMessage");
        label.setText("메시지가 왔습니다.");

        popup.getContent().add(hBox);
        popup.setAutoHide(true);
        popup.show(primaryStage);
    }

    // 커스텀 다이얼로그 실행
    public void handleCustom(ActionEvent e) throws Exception {
        Stage dialog = new Stage(StageStyle.UTILITY);
        dialog.initModality(Modality.WINDOW_MODAL); // 모달리스가 아닌, 모달로 설정
        dialog.initOwner(primaryStage);
        dialog.setTitle("확인");

        AnchorPane anchorPane = (AnchorPane) FXMLLoader.load(getClass().getResource("custom/custom_dialog.fxml"));
        Label textTitle = (Label) anchorPane.lookup("#textTitle");
        textTitle.setText("확인하셨습니까?");
        Button button = (Button) anchorPane.lookup("#buttonOk");
        button.setOnAction(event -> dialog.close());

        Scene scene = new Scene(anchorPane);
        dialog.setScene(scene);
        dialog.setResizable(false);
        dialog.show();
    }
}
