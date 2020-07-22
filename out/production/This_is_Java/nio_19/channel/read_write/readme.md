#### 파일 쓰기와 읽기

- 파일 쓰기

파일에 바이트를 쓰려면 `FileChannel`의 `write()` 메소드를 호출하면 된다.

write의 매개값으로는 ByteBuffer 객체를 주면 된다.

`int bytesCount = fileChannel.write(ByteBuffer src);`

파일에 쓰여지는 바이트는 `ByteBuffer`의 **position ~ limit**까지이다.

- 파일 읽기

파일 읽기는 `read()`메소드를 호출하면 된다.

`int bytesCount = fileChannel.read(ByteBuffer dst);`

파일에서 읽혀지는 바이트는 `ByteBuffer`의 `position`부터 저장된다.

더 이상 읽은 바이트가 없다면 read()는 `-1`을 리턴한다.