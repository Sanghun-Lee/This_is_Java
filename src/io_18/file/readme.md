#### 파일 입출력

##### File 클래스

File 클래스는 `파일 크기`, `파일 속성`, `파일 이름`과 같이 `정보를 얻는 기능`과

`파일 생성`, `파일 삭제` 기능을 제공하고 있다.

그러나 파일을 `데이터를 읽고 쓰는 기능`은 제공하지 않는다.

> File 객체 생성

`File file = new File("Path");`

File 객체를 생성했다고 해서 파일이 생성되는건 아니다.

그래서 `file.exists()`로 파일 존재 여부를 확인해야 한다.

> File class의 메소드

File에서 사용할 수 있는 메소드들은 아래와 같다.

너무 많아서 주요한 메소드만 정리하겠다.

- boolean createNewFile() : 새로운 파일 생성
- boolean mkdir() : 새로운 디렉토리 생성
- boolean mkdirs() : 경로상에 없는 모든 디렉토리 생성
- boolean delete() : 파일 또는 디렉토리 삭제

- boolean can[Execute/Read/Write]

- String getPath() : 전체 경로 리턴