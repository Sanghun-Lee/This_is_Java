package nio_19.channel.copy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCopyMethodExample {
    public static void main(String[] args) throws IOException {
        Path from = Paths.get("/home/hun/Pictures/1.png");
        Path to = Paths.get("/home/hun/Pictures/1_copy.png");

        Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("복사 성공");
    }
}
