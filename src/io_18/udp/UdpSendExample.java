package io_18.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UdpSendExample {
    public static void main(String[] args) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket();

        System.out.println("[발신 시작]");

        for(int i = 1; i < 3; i++) {
            String data = "메시지" + i;
            byte[] bytes = data.getBytes("UTF-8");

            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, new InetSocketAddress("localhost", 5001));

            datagramSocket.send(datagramPacket);
            System.out.println("[보낸 데이터 수] : " + bytes.length + " bytes");
        }

        System.out.println("[발신 종료]");
        datagramSocket.close();
    }
}
