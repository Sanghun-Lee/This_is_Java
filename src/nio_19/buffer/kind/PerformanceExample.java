package nio_19.buffer.kind;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;

/**
 * non-direct buffer와 direct buffer 성능 비교
 */

public class PerformanceExample {
    public static void main(String[] args) throws Exception {
        Path from = Paths.get("/home/hun/Desktop/temp/house.jpg");
        Path to1 = Paths.get("/home/hun/Desktop/temp/house2.jpg");
        Path to2 = Paths.get("/home/hun/Desktop/temp/house3.jpg");

        long size = Files.size(from);

        FileChannel fileChannel_from = FileChannel.open(from);
        FileChannel fileChannel_to1 = FileChannel.open(to1, EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE));
        FileChannel fileChannel_to2 = FileChannel.open(to2, EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE));

        ByteBuffer nonDirectBuffer = ByteBuffer.allocate((int) size);
        ByteBuffer DirectBuffer = ByteBuffer.allocateDirect((int) size);

        long start, end;

        start = System.nanoTime();
        for(int i = 0; i < 100; i++) {
            fileChannel_from.read(nonDirectBuffer);
            nonDirectBuffer.flip();
            fileChannel_to1.write(nonDirectBuffer);
            nonDirectBuffer.clear();
        }
        end = System.nanoTime();

        System.out.println("non-direct buffer : " + (end - start) + " ns");

        fileChannel_from.position(0);

        start = System.nanoTime();
        for(int i = 0; i < 100; i++) {
            fileChannel_from.read(DirectBuffer);
            DirectBuffer.flip();
            fileChannel_to1.write(DirectBuffer);
            DirectBuffer.clear();
        }
        end = System.nanoTime();
        System.out.println("direct buffer : " + (end - start) + " ns");

        fileChannel_from.close();
        fileChannel_to1.close();
        fileChannel_to2.close();
    }
}
