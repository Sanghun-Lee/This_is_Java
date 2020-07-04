package javafx_17.css.adapt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain_css extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("root1.fxml"));
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(getClass().getResource("app1.css").toString());

        stage.setTitle("AppMain_Css");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
