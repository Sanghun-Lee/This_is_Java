package nio_19.channel.read_write;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChannelWriteExample {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("/home/hun/temp2.txt");

        FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.CREATE ,StandardOpenOption.WRITE);

        String data = "hello";
        Charset charset = Charset.defaultCharset();
        ByteBuffer byteBuffer = charset.encode(data);

        int byteCount = fileChannel.write(byteBuffer);
        System.out.println("file.txt : " + byteCount + " bytes written");

        fileChannel.close();
    }
}
