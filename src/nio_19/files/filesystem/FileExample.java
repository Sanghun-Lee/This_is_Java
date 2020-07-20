package nio_19.files.filesystem;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileExample {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("/home/hun/Documents/This_is_Java/src/nio_19/files/filesystem/FileExample.java");
        System.out.println("디렉토리 여부 : " + Files.isDirectory(path));
        System.out.println("파일 여부 : " + Files.isRegularFile(path));
        System.out.println("마지막 수정 시간 : " + Files.getLastModifiedTime(path));
        System.out.println("파일 크기 : " + Files.size(path));
        System.out.println("소유자 : " + Files.getOwner(path));
        System.out.println("숨김 파일 여부 : " + Files.isHidden(path));
        System.out.println("읽기 가능 여부 : " + Files.isReadable(path));
        System.out.println("쓰기 가능 여부 : " + Files.isWritable(path));
    }
}
