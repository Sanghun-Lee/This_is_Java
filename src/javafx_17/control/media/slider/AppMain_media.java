package javafx_17.control.media.slider;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain_media extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = (Parent) FXMLLoader.load(getClass().getResource("root.fxml"));

        Scene scene = new Scene(parent);

        stage.setTitle("AppMain_media");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}