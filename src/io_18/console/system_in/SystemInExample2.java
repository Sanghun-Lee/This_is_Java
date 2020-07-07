package io_18.console.system_in;

import java.io.InputStream;

public class SystemInExample2 {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;

        byte[] datas = new byte[100];

        System.out.print("이름 : ");
        int nameBytes = inputStream.read(datas);
        String name = new String(datas, 0, nameBytes - 2);  // 엔터가 2byte라서 -2만큼 변환

        System.out.print("하고 싶은 말 : ");
        int commentBytes = inputStream.read(datas);
        String comment = new String(datas, 0, commentBytes - 2);

        System.out.println("입력한 이름 : " + name);
        System.out.println("입력한 하고 싶은말 : " + comment);
    }
}
