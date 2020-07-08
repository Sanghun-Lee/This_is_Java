package io_18.assistant.object.serialVersionUID;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerialVersionUIDExample1 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("/home/hun/object.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        ClassC classC = new ClassC();
        classC.field1 = 1;
        classC.field2 = 5;

        oos.writeObject(classC);
        oos.flush(); oos.close(); fos.close();
    }
}
