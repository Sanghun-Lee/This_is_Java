package nio_19.files.filesystem;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 디렉토리 내용 얻기
 */

public class DirectoryExample {
    public static void main(String[] args) throws Exception {
        Path path1 = Paths.get("/home/hun/Desktop/react");
        Path path2 = Paths.get("home/hun/Desktop/nodejs");

        if(Files.notExists(path1)) {
            Files.createDirectories(path1);
        }

        if(Files.notExists(path2)) {
            Files.createDirectories(path2);
        }

        Path path3 = Paths.get("/home/hun/Desktop/usimm-v1.3");
        // 디렉토리 내용을 스트림(반복자)으로 얻음
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path3);

        for(Path path : directoryStream) {
            if(Files.isDirectory(path)) {
                System.out.println("[디렉토리] " + path.getFileName());
            } else {
                System.out.println("[파일] " + path.getFileName() + " (크기 : " + Files.size(path) + " )");
            }
        }
    }
}
