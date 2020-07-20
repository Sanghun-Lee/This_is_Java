package nio_19.files.watch;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.nio.file.*;
import java.util.List;

public class WatchServiceExample extends Application {
    class WatchServiceThread extends Thread {
        @Override
        public void run() {
            try {
                WatchService watchService = FileSystems.getDefault().newWatchService();
                Path directory = Paths.get("/home/hun/Desktop/temp");
                directory.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
                        StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);

                while(true) {
                    WatchKey watchKey = watchService.take();    // blocking (WatchKey가 큐에 들어올 때까지)
                    List<WatchEvent<?>> list = watchKey.pollEvents();   // WatchEvent 목록 얻기

                    for(WatchEvent watchEvent : list) {
                        // 이벤트 종류 얻기
                        WatchEvent.Kind kind = watchEvent.kind();

                        // 감시된 Path 얻기
                        Path path = (Path) watchEvent.context();
                        if(kind == StandardWatchEventKinds.ENTRY_CREATE) {
                            // 생성되었을 경우, 실행할 코드
                            Platform.runLater(() -> textArea.appendText("파일 생성됨 -> " + path.getFileName() + " \n"));
                        } else if(kind == StandardWatchEventKinds.ENTRY_DELETE) {
                            // 삭제되었을 경우, 실행할 코드
                            Platform.runLater(() -> textArea.appendText("파일 삭제됨 -> " + path.getFileName() + " \n"));
                        } else if(kind == StandardWatchEventKinds.ENTRY_MODIFY) {
                            // 변경되었을 경우, 실행할 코드
                            Platform.runLater(() -> textArea.appendText("파일 변경됨 -> " + path.getFileName() + " \n"));
                        } else if(kind == StandardWatchEventKinds.OVERFLOW) {}
                    }

                    boolean valid = watchKey.reset();
                    if(valid == false) { break; }
                }
            } catch (Exception e) {}
        }
    }   // end of WatchServiceThread class

    TextArea textArea;

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        root.setPrefSize(500, 300);

        textArea = new TextArea();
        textArea.setEditable(false);
        root.setCenter(textArea);

        Scene scene = new Scene(root);

        stage.setTitle("WatchService");
        stage.setScene(scene);
        stage.show();

        WatchServiceThread watchServiceThread = new WatchServiceThread();
        watchServiceThread.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
