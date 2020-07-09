package io_18.tcp.communication;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("localhost", 10000));

            while(true) {
                System.out.println("[연결 기다림]");
                Socket socket = serverSocket.accept();  // accept 메소드는 요청이 올 때 까지 blocking 된다.
                // client에게 요청을 받으면 Socket 정보를 리턴한다.

                InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
                System.out.println("[연결 수락함] " + inetSocketAddress.getHostName());

                byte[] bytes = null;
                String message = null;

                InputStream inputStream = socket.getInputStream();
                bytes = new byte[100];
                int readByteCount = inputStream.read(bytes);
                message = new String(bytes, 0, readByteCount, "UTF-8");
                System.out.println("[데이터 받기 성공] : " + message);

                OutputStream outputStream = socket.getOutputStream();
                message = "Hello Client";
                bytes = message.getBytes("UTF-8");
                outputStream.write(bytes);
                outputStream.flush();
                System.out.println("[데이터 보내기 성공]");

                inputStream.close();
                outputStream.close();
                socket.close();
            }
        } catch (Exception e) {}

        if(!serverSocket.isClosed()) {
            try {
                serverSocket.close();
            } catch (IOException e) {}
        }
    }
}
