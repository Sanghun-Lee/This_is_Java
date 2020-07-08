package io_18.assistant.object.serializable;

import java.io.Serializable;

public class ClassA implements Serializable {
    int field1;
    ClassB field2 = new ClassB();
    // 여기까지 직렬화 가능

    static int field3;
    transient int field4;
    // 위 두 필드는 직렬화 불가능

}
