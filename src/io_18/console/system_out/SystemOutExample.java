package io_18.console.system_out;

import java.io.OutputStream;

public class SystemOutExample {
    public static void main(String[] args) throws Exception {
        OutputStream outputStream = System.out;

        for(byte b = 48; b < 58; b++) {
            outputStream.write(b);
        }
        outputStream.write(10); // 다음행으로 넘어간다.

        for(byte b = 97; b < 123; b++) {
            outputStream.write(b);
        }

        outputStream.write(10);

        String hangul = "가나다라마바사아자차카타파하";
        byte[] hangulBytes = hangul.getBytes();
        outputStream.write(hangulBytes);

        outputStream.flush();
    }
}
