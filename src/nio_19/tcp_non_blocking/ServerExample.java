package nio_19.tcp_non_blocking;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class ServerExample extends Application {
    Selector selector;
    ServerSocketChannel serverSocketChannel;
    List<Client> connections = new Vector<>();

    // Selector 생성, non-blocking ServerSocketChannel 생성 및 포트 바인딩
    // Selector 등록, 작업 스레드 생성
    void startServer() {
        // 서버 시작 코드
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            // bind 해야됨
            serverSocketChannel.bind(new InetSocketAddress(5001));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (Exception e) {
            if(serverSocketChannel.isOpen()) {
                stopServer();
            }
            return;
        }

        Thread thread = new Thread() {
            @Override
            public void run() {
                while(true) {
                    try {
                        int keyCount = selector.select();
                        if(keyCount == 0) { continue; }
                        Set<SelectionKey> selectionKeys = selector.selectedKeys();
                        Iterator<SelectionKey> iterator = selectionKeys.iterator();
                        while(iterator.hasNext()) {
                            SelectionKey selectionKey = iterator.next();
                            if(selectionKey.isAcceptable()) {
                                // 연결 수락 작업일 경우
                                accept(selectionKey);
                            } else if(selectionKey.isReadable()) {
                                // 읽기 작업일 경우
                                Client client = selectionKey.attachment();
                                client.receive(selectionKey);
                            } else if (selectionKey.isWritable()) {
                                // 쓰기 작업일 경우
                                Client client = selectionKey.attachment();
                                client.send(selectionKey);
                            }
                            iterator.remove();
                        }

                    } catch (Exception e) {
                        if(serverSocketChannel.isOpen()) {
                            stopServer();
                        }
                        break;
                    }
                }
            }
        };

        thread.start();

        Platform.runLater(() -> displayText("서버 시작"));
    }

    // 모든 SocketChannel 닫기, ServerSocketChannel닫기, Selector 닫기
    void stopServer() {
        // 서버 종료 코드
        try {
            Iterator<Client> iterator = connections.iterator();
            while(iterator.hasNext()) {
                Client client = iterator.next();
                client.socketChannel.close();
                iterator.remove();
            }

            if(serverSocketChannel != null && serverSocketChannel.isOpen())
                serverSocketChannel.close();

            if(selector != null && selector.isOpen()) {
                selector.close();
            }
            Platform.runLater(() -> {
                displayText("서버 멈춤");
                buttonStartStop.setText("start");
            });
        } catch (Exception e) {}
    }

    void accept(SelectionKey selectionKey) {
        // 클라이언트로 부터 온 연결 수락 코드

    }

    class Client {
        // 데이터 통신 코드
        SocketChannel socketChannel;
        String sendData;

        Client(SocketChannel socketChannel) throws Exception {
            this.socketChannel = socketChannel;
            socketChannel.configureBlocking(false);
            SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_READ);
            selectionKey.attach(this);
        }

        void receive(SelectionKey selectionKey) {
            // 전송된 데이터 받기
        }

        void send(SelectionKey selectionKey) {
            // 데이터 전송
        }

    }

    ///////////////////////////////////
    // UI 생성 코드
    TextArea textArea;
    Button buttonStartStop;

    void displayText(String text) {
        textArea.appendText(text + "\n");
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        root.setPrefSize(500, 300);

        textArea = new TextArea();
        textArea.setEditable(false);
        BorderPane.setMargin(textArea, new Insets(0, 0, 2, 0));
        root.setCenter(textArea);

        buttonStartStop = new Button("start");
        buttonStartStop.setPrefHeight(30);
        buttonStartStop.setMaxWidth(Double.MAX_VALUE);

        buttonStartStop.setOnAction(event -> {
            // start 버튼을 클릭했을 경우
            if(buttonStartStop.getText().equals("start")) {
                startServer();
            } else if(buttonStartStop.getText().equals("stop")) {
                stopServer();
            }
        });

        root.setBottom(buttonStartStop);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("app.css").toString());
        stage.setTitle("Server");
        stage.setScene(scene);
        stage.setOnCloseRequest(windowEvent -> stopServer());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
