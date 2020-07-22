package nio_19.tcp_blocking.socket;

import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerExample {
    public static void main(String[] args) {
        ServerSocketChannel serverSocketChannel = null;
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(true);
            serverSocketChannel.bind(new InetSocketAddress(5001));

            while(true) {
                System.out.println("연결을 기다린다.");
                SocketChannel socketChannel = serverSocketChannel.accept();
                InetSocketAddress inetSocketAddress = (InetSocketAddress) socketChannel.getRemoteAddress();
                System.out.println("연결 수락함");
            }
        } catch (Exception e) {}

        if(serverSocketChannel.isOpen()) {
            try {
                serverSocketChannel.close();
            } catch (Exception e) {}
        }
    }
}
