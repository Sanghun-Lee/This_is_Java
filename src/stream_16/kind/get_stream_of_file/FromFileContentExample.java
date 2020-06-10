package stream_16.kind.get_stream_of_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

// 파일에서부터 스트림을 얻는 방법

public class FromFileContentExample {
    public static void main(String[] args) throws IOException {
        // Path : 파일의 경로에 대한 정보를 가지고 있다.
        Path path = Paths.get("src/stream_16/list/get_stream_of_file/linedata.txt");
        Stream<String> stream;

        // Files.lines() 메소드 이용
        stream = Files.lines(path, Charset.defaultCharset());   // Charset.defaultCharset() : 운영체제가 사용하는 기본 문자 셋
        stream.forEach(System.out :: println);  // 메소드 참조 사용
        // stream.forEach(s->System.out.println(s));
        System.out.println();

        // BufferedReader의 lines() 메소드 이용
        File file = path.toFile();
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        stream = br.lines();    // lines 메소드로 stream 을 얻을 수 있다.
        stream.forEach(System.out :: println);
    }
}
