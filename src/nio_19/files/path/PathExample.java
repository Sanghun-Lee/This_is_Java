package nio_19.files.path;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class PathExample {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("home/hun/네트워크 6강");
        System.out.println("[파일 명] : " + path.getFileName());
        System.out.println("[부모 디렉토리 명] : " + path.getParent().getFileName());
        System.out.println("중첩 경로 수 : " + path.getNameCount());

        System.out.println();
        for(int i = 0; i < path.getNameCount(); i++) {
            System.out.println(path.getName(i));
        }

        System.out.println();
        Iterator<Path> iterator = path.iterator();
        while(iterator.hasNext()) {
            Path tmp = iterator.next();
            System.out.println(tmp.getFileName());
        }
    }
}
