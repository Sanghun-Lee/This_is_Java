#### 파일 시스템 정보 (FileSystem)

파일 시스템 객체 얻기

예시 파일 : `FileSystemExample.java`

```java
FileSystem fileSystem = FileSystems.getDefault();
```

FileSystem은 다음과 같은 메소드를 제공한다.

| 리턴 타입 | 메소드 | 설명 |
| --- | --- | --- |
| Iterable\<FileStore> | getFileStores() | 드라이버(C, D..) 정보를 가진 FileStore 객체를 리턴 |
| Iterable\<Path> | getRootDirectories() | 루트 디렉토리 정보를 가진 Path 객체들을 리턴 |
| String | getSeparator() | 디렉토리 구분자 리턴 |

 ---
 
 ##### 파일 속성 읽기 및 파일, 디렉토리 생성 / 삭제
 
 `java.nio.file.Files` 클래스는 파일과 디렉토리의 생성 및 삭제, 그리고 이들의 속성을 읽는 메소드를 제공한다.
 
 해당 메소드 종류는 책을 참고하길 바란다.
 
 예시 파일 : `FileExample.java`, `DirectoryExample.java`