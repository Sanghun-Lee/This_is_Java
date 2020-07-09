package io_18.tcp.chatting;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientExample extends Application {
    Socket socket;

    // 연결 시작 코드
    void startClient() {
        // Client는 thread가 하나만 있으면 되기 때문에 Thread 클래스로 생성한다.
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    // 1. socket 생성 및 연결 요청 - 끝
                    socket = new Socket();
                    socket.connect(new InetSocketAddress("localhost", 5001));

                    // 2. UI update
                    Platform.runLater(() -> {
                        displayText("[연결 완료 : " + socket.getRemoteSocketAddress() + "]");
                        buttonConnection.setText("stop");
                        buttonSend.setDisable(false);
                    });
                } catch (Exception e) {
                    // socket close
                    Platform.runLater(() -> displayText("[서버 통신 안됨]"));
                    if(!socket.isClosed()) {
                        stopClient();
                    }
                    return;
                }

                receive();  // 서버에서 보낸 데이터 받기
            }
        };  // end of thread
        thread.start();
    }

    // 연결 끊기 코드
    void stopClient() {
        try {
            Platform.runLater(() -> {
                displayText("[연결 끊음]");
                buttonConnection.setText("start");
                buttonSend.setDisable(true);
            });
            if(socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {}
    }

    // 데이터 받기 코드
    void receive() {
        while (true) {
            try {
                byte[] bytes = new byte[100];
                InputStream inputStream = socket.getInputStream();

                // 서버가 비정상적으로 종료했을 경우 IOException 발생
                int readByteCount = inputStream.read(bytes);

                if(readByteCount == -1) { throw new IOException(); }

                String data = new String(bytes, 0, readByteCount, "UTF-8");

                Platform.runLater(() -> displayText("[받기 완료] " + data));
            } catch (Exception e) {
                Platform.runLater(() -> displayText("[서버 통신 안됨]"));
                stopClient();
                break;
            }
        }
    }

    // 데이터 보내기 코드
    void send(String data) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    byte[] bytes = data.getBytes("UTF-8");
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write(bytes);
                    outputStream.flush();
                    Platform.runLater(() -> displayText("[보내기 완료]"));
                } catch (Exception e) {
                    Platform.runLater(() -> displayText("[서버 통신 안됨]"));
                    stopClient();
                }
            }
        };  // end of thread
        thread.start();
    }

    ////////////////////////////
    // UI 생성 코드
    TextArea textArea;
    TextField textInput;
    Button buttonConnection, buttonSend;

    void displayText(String text) {
        textArea.appendText(text + "\n");
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        root.setPrefSize(500, 300);

        textArea = new TextArea();
        textArea.setEditable(false);
        BorderPane.setMargin(textArea, new Insets(0, 2, 0, 0));
        root.setCenter(textArea);

        BorderPane bottom = new BorderPane();
        textInput = new TextField();
        textInput.setPrefSize(60, 30);
        BorderPane.setMargin(textInput, new Insets(0, 1 ,1 ,1));

        buttonConnection = new Button("start");
        buttonConnection.setPrefSize(60, 30);
        buttonConnection.setOnAction(event -> {
            if(buttonConnection.getText().equals("start")) {
                startClient();
            } else if(buttonConnection.getText().equals("stop")) {
                stopClient();
            }
        });

        buttonSend = new Button("send");
        buttonSend.setPrefSize(60, 30);
        buttonSend.setDisable(true);
        buttonSend.setOnAction(event -> send(textInput.getText()));

        bottom.setCenter(textInput);
        bottom.setLeft(buttonConnection);
        bottom.setRight(buttonSend);
        root.setBottom(bottom);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("app.css").toString());
        stage.setScene(scene);
        stage.setTitle("Client");
        stage.setOnCloseRequest(windowEvent -> stopClient());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
