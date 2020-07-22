package nio_19.tcp_blocking.chatting;

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
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ClientExample extends Application {
    SocketChannel socketChannel;

    void startClient() {
        // 연결 시작
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    socketChannel = SocketChannel.open();
                    socketChannel.configureBlocking(true);
                    socketChannel.connect(new InetSocketAddress("localhost", 5001));
                    Platform.runLater(() -> {
                        try {   // socketChannel.getRemoteAddress() 메소드 때문에 try - catch문 존재
                            displayText("[연결 완료 : " + socketChannel.getRemoteAddress() + "]");
                            buttonConnection.setText("stop");
                            buttonSend.setDisable(false);
                        } catch (Exception e) {}
                    }); // Platform.runLater()
                } catch (Exception e) {
                    Platform.runLater(() -> displayText("[서버 통신 안됨]"));
                    if(socketChannel.isOpen() == true) { stopClient(); }
                    return;
                }
                receive();
            }   // end of run method
        };  // end of Thread
        thread.start();
    }

    void stopClient() {
        // 연결 종료
        try {
            Platform.runLater(() -> {
                displayText("[연결 끊음]");
                buttonConnection.setText("start");
                buttonSend.setDisable(true);
            });

            if(socketChannel != null && socketChannel.isOpen()) {
                socketChannel.close();
            }
        } catch (Exception e) {}
    }

    void receive() {
        // 데이터 받기 코드
        while(true) {
            try {
                ByteBuffer byteBuffer = ByteBuffer.allocate(100);

                // 서버가 비정상적으로 종료했을 경우 IOException 발생
                int readByteCount = socketChannel.read(byteBuffer);

                // 서버가 정상적으로 Socket의 close()를 호출했을 경우
                if(readByteCount == -1) {
                    throw new IOException();
                }

                byteBuffer.flip();
                Charset charset = Charset.forName("UTF-8");
                String data = charset.decode(byteBuffer).toString();

                Platform.runLater(() -> displayText("[받기 완료]" + data));
            } catch (IOException e) {
                Platform.runLater(() -> displayText("[서버 통신 안됨]"));
                stopClient();
                break;
            }
        }
    }

    void send(String data) {
        // 데이터 전송 코드
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Charset charset = Charset.forName("UTF-8");
                    ByteBuffer byteBuffer = charset.encode(data);
                    socketChannel.write(byteBuffer);
                    Platform.runLater(() -> displayText("[보내기 완료]"));
                } catch (Exception e) {
                    Platform.runLater(() -> displayText("[서버 통신 안됨]"));
                    stopClient();
                }
            }
        };

        thread.start();
    }

    /////////////////////////////
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
