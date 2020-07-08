package io_18.assistant.primitive;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataInputOutputStreamExample {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("/home/hun/test.dat");
        DataOutputStream dataOutputStream = new DataOutputStream(fos);

        dataOutputStream.writeUTF("홍길동");
        dataOutputStream.writeDouble(95.5);
        dataOutputStream.writeInt(1);

        dataOutputStream.writeUTF("김자바");
        dataOutputStream.writeDouble(90.3);
        dataOutputStream.writeInt(2);

        dataOutputStream.flush();
        dataOutputStream.close();
        fos.close();

        FileInputStream fis = new FileInputStream("/home/hun/test.dat");
        DataInputStream dataInputStream = new DataInputStream(fis);

        // 읽을 때에는 쓴 순서에 맞게 읽어야 한다.
        for(int i = 0; i < 2; i++) {
            String name = dataInputStream.readUTF();
            double score = dataInputStream.readDouble();
            int order = dataInputStream.readInt();
            System.out.println(name + " : " + score + " : " + order);
        }

        dataInputStream.close();
        fis.close();
    }
}
