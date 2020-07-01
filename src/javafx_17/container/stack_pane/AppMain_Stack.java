package javafx_17.container.stack_pane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AppMain_Stack extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        StackPane stackPane = FXMLLoader.load(getClass().getResource("root.fxml"));

        Scene scene = new Scene(stackPane);

        stage.setTitle("AppMain StackPane");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
