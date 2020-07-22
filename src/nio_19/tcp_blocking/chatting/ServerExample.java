package nio_19.tcp_blocking.chatting;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerExample extends Application {
    ExecutorService executorService;
    ServerSocketChannel serverSocketChannel;
    List<Client> connections = new Vector<Client>();

    void startServer() {
        // 스레드 풀 생성, ServerSocketChannel생성
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(true);
            serverSocketChannel.bind(new InetSocketAddress(5001));
        } catch (Exception e) {
            if(serverSocketChannel.isOpen()) {
                stopServer();
            }
            return;
        }

        // 연결 수락 작업은 새로운 스레드를 만든 후, 해당 스레드에서 작동하도록 만들어 준다.
        Runnable runnable = () -> {
            Platform.runLater(() -> {
                displayText("[서버 시작]");
                buttonStartStop.setText("stop");
            }); // end of Platform.runLater

            while(true) {
                try {
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    String message = "[연결 수락 : " + socketChannel.getRemoteAddress() + " : " + Thread.currentThread().getName() + "]";
                    Platform.runLater(() -> displayText(message));

                    Client client = new Client(socketChannel);
                    connections.add(client);

                    Platform.runLater(() -> displayText("연결 개수 : " + connections.size() + "]"));
                } catch (Exception e) {
                    if(serverSocketChannel.isOpen()) {
                        stopServer();
                    }
                }
            }
        };

        executorService.submit(runnable);
    }   // end of startServer();
    void stopServer() {
        try {
            Iterator<Client> iterator = connections.iterator();
            while(iterator.hasNext()) {
                Client client = iterator.next();
                client.socketChannel.close();
                iterator.remove();
            }

            if(serverSocketChannel != null && serverSocketChannel.isOpen()) {
                serverSocketChannel.close();
            }
            if(executorService != null && executorService.isShutdown() == false) {
                executorService.shutdown();
            }

            Platform.runLater(() -> {
                displayText("[서버 멈춤]");
                buttonStartStop.setText("start");
            });
        } catch (Exception e) {}
    }

    class Client {
        SocketChannel socketChannel;

        Client(SocketChannel socketChannel) {
            this.socketChannel = socketChannel;
            receive();
        }

        // 데이터 받기 코드
        // 스레드 풀의 작업 스레드가 처리하도록 Runnable로 작업을 정의하고 있고,
        // 클라이언트가 보낸 데이터를 반복적으로 받기 위해 SocketChannel의 read() 메소드를 호출하고 있다.
        void receive() {
            Runnable runnable = () -> {
                while(true) {
                    try {
                        ByteBuffer byteBuffer = ByteBuffer.allocate(100);

                        // 클라이언트가 비정상 종료를 했을 경우 IOException 발생
                        int readByteCount = socketChannel.read(byteBuffer);

                        // 클라이언트가 정상적으로 SocketChannel의 close() 메소드를 호출했을 경우
                        if(readByteCount == -1) {
                            throw new IOException();
                        }

                        String message = "[요청 처리 : " + socketChannel.getRemoteAddress() + " : " + Thread.currentThread().getName() + "]";
                        Platform.runLater(() -> displayText(message));

                        byteBuffer.flip();
                        Charset charset = Charset.forName("UTF-8");
                        String data = charset.decode(byteBuffer).toString();

                        for(Client client : connections) {
                            client.send(data);
                        }
                    } catch (Exception e) {
                        try {
                            connections.remove(Client.this);
                            String message = "[클라이언트 통신 안됨 : " + socketChannel.getRemoteAddress() + " : " + Thread.currentThread().getName() + "]";
                            Platform.runLater(() -> displayText(message));
                            socketChannel.close();
                        } catch (IOException e1) {}
                        break;
                    }
                }
            };
            executorService.submit(runnable);
        }

        // 데이터 전송 코드
        void send(String data) {
            Runnable runnable = () -> {
                try {
                    Charset charset = Charset.forName("UTF-8");
                    ByteBuffer byteBuffer = charset.encode(data);
                    socketChannel.write(byteBuffer);
                } catch (Exception e) {
                    try {
                        String message = "[클라이언트 통신 안됨 : " + socketChannel.getRemoteAddress() + " : " + Thread.currentThread().getName() + "]";
                        Platform.runLater(() -> displayText(message));
                        connections.remove(Client.this);
                        socketChannel.close();
                    } catch (Exception e1) {}
                }
            };

            executorService.submit(runnable);
        }
    }

    ///////////////////
    // UI생성 코드
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
