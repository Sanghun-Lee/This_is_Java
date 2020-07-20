#### 파일 복사

파일 복사를 구현하기 위해선 `하나의 ByteBuffer`를 사이에 두고,

파일 읽기용 FileChannel과 파일 쓰기용 FileChannel이 읽기와 쓰기를 교대로 할 수 있다.

---

위 예제처럼 작성할 수 있지만, 단순히 파일을 복사한다면 `NIO의 Files`클래스의 `copy()` 메소드를 사용하는 것이 더 편리하다.

```java
Path targetPath = Files.copy(Path source, Path target, CopyOption... options);
```

- options

> REPLACE_EXISTING  : 타겟 파일이 존재하면 대체한다.
> 
> COPY_ATTRIBUTES : 파일의 속성까지도 복사한다.
>
> NOFOLLOW_LINKS : 링크 파일일 경우 링크 파일만 복사하고 링크된 파일은 복사하지 않는다.