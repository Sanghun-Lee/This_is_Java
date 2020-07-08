package io_18.assistant.object.serialVersionUID;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class SerialVersionUIDExample2 {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("home/hun/object.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);

        ClassC classC = (ClassC) ois.readObject();

        System.out.println("field1 : " + classC.field1);

        ois.close(); fis.close();
    }
}
