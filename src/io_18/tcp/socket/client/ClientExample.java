package io_18.tcp.socket.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientExample {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket();  // socket 생성
            System.out.println("연결 요청");
            socket.connect(new InetSocketAddress("localhost", 10000));  // 연결 요청
            System.out.println("[연결 성공]");
        } catch (Exception e) {}

        if(!socket.isClosed()) {
            try {
                socket.close();
            } catch (IOException e) {}
        }
    }
}
