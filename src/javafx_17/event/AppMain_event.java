package javafx_17.event;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AppMain_event extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        HBox root = new HBox();
        root.setPrefSize(200, 50);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);

        Button button = new Button("버튼1");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("버튼1 클릭");
            }
        });

        Button btn2 = new Button("버튼2");
        btn2.setOnAction(event -> System.out.println("버튼2 클릭"));

        root.getChildren().addAll(button, btn2);    // HBox에 button과 btn2 추가
        Scene scene = new Scene(root);

        stage.setTitle("AppMain event handler");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
