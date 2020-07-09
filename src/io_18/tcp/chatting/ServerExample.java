package io_18.tcp.chatting;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerExample extends Application {
    ExecutorService executorService;
    ServerSocket serverSocket;
    List<Client> connections = new Vector<>();  // thread에 안전한 vector를 생성

    void startServer() {
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        // ServerSocket 생성 및 포트 바인딩
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("localhost", 5001));
        } catch (Exception e) {
            if(!serverSocket.isClosed()) {
                stopServer();
            }
            return;
        }

        Runnable runnable = () -> {
            Platform.runLater(() -> {   // UI변경 요청은 JavaFx App Thread에서만 실행되어야 하기 때문에
                // Platform.runLater로 UI변경 요청을 보낸다.
                displayText("[서버 시작]");
                buttonStartStop.setText("stop");
            });

            while(true) {
                try {
                    Socket socket = serverSocket.accept();
                    String message = "[연결 수락 : " + socket.getRemoteSocketAddress() + " : " + Thread.currentThread().getName() + "]";
                    Platform.runLater(() -> displayText(message));

                    // 연결 받은 Client 객체를 저장한다.
                    Client client = new Client(socket);
                    connections.add(client);
                    Platform.runLater(() -> displayText("[연결 개수 : " + connections.size() + "]"));
                } catch (Exception e) {
                    if(!serverSocket.isClosed()) {
                        stopServer();
                    }
                    break;
                }
            }
        };  // Runnable 구현객체 끝
        executorService.submit(runnable);
    }// end of startServer()

    void stopServer() {
        try {
            Iterator<Client> iterator = connections.iterator();

            // 모든 client socket 닫기
            while(iterator.hasNext()) {
                Client client = iterator.next();
                client.socket.close();
                iterator.remove();
            }

            // serverSocket 닫기
            if(serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }

            // executorService(스레드 풀) 닫기
            if(executorService != null && !executorService.isShutdown()) {
                executorService.shutdown();
            }

            Platform.runLater(() -> {
                displayText("서버 멈춤");
                buttonStartStop.setText("start");
            });
        } catch (Exception e) {}
    }

    class Client {
        Socket socket;
        public Client(Socket socket) {
            this.socket = socket;
            receive();
        }

        void receive() {
            // 데이터를 받는 코드
            // 데이터를 받는 새 스레드 생성
            Runnable runnable = () -> {
                try {
                    while (true) {
                        byte[] byteArr = new byte[100];
                        InputStream inputStream = socket.getInputStream();

                        int readCount = inputStream.read(byteArr);
                        // 데이터를 제대로 못 받았을 경우 예외 생성
                        if(readCount == -1) { throw new IOException(); }

                        String message = "[요청 처리 : " + socket.getRemoteSocketAddress() + " : " + Thread.currentThread().getName() + " ]";
                        Platform.runLater(() -> displayText(message));

                        String data = new String(byteArr, 0, readCount, "UTF-8");

                        // 다른 모든 클라이언트에게 데이터를 보낸다.
                        for(Client client : connections) {
                            client.send(data);
                        }
                    }
                } catch (Exception e) {
                    try {
                        connections.remove(Client.this);
                        String message = "[클라이언트 통신 안됨 : " + socket.getRemoteSocketAddress() + " : " + Thread.currentThread().getName() + "]";
                        Platform.runLater(() -> displayText(message));
                        socket.close();
                    } catch (IOException ioException) {}
                }
            };
            // 스레드 풀에서 receive 메소드 처리
            executorService.submit(runnable);
        }

        void send(String data) {
            // 데이터를 보내는 코드
            Runnable runnable = () -> {
                try {
                    OutputStream outputStream = socket.getOutputStream();
                    byte[] bytes = data.getBytes("UTF-8");
                    outputStream.write(bytes);
                    outputStream.flush();
                } catch (Exception e) {
                    try {
                        String message = "[클라이언트 통신 안됨 : " + socket.getRemoteSocketAddress() + " : " + Thread.currentThread().getName() + "]";
                        Platform.runLater(() -> displayText(message));
                        connections.remove(Client.this);
                        socket.close();
                    } catch (IOException ioException) {}
                }
            };  // end of Runnable
            // 스레드 풀에서 send 메소드 처리
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
