package javafx_17.animation.slide;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain_slide extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("AppMain_fade");
        Parent root = FXMLLoader.load(getClass().getResource("root.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setWidth(350);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
