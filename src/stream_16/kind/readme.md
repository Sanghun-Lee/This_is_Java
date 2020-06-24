#### 스트림의 종류

Stream의 경우 다음과 같이 `BaseStream`인터페이스를 부모로 해서 자식 인터페이스들이 상속관계를 이루고 있다.

- BaseStream
    - Stream
    - IntStream
    - LongStream
    - DoubleStream
    
BaseStream 인터페이스는 모든 스트림에서 사용할 수 있는 공통 메소드들이 정의되어 있을 뿐

코드에서 직접적으로 사용되지는 않는다.

> Stream

Stream은 객체 요소를 처리하는 스트림이다.

> (Int, Long, Double)Stream

각각 기본 타입인 int, long, double 요소를 처리하는 스트림이다.

| 챕터 | 패키지 | 설명 |
| --- | --- | --- |
| 16.2.1 | get_stream_of_collection | 컬렉션으로부터 스트림 얻기 |
| 16.2.2 | get_stream_of_array | 배열로부터 스트림 얻기 |
| 16.2.3 | get_stream_of_number | 숫자 범위로부터 스트림 얻기 |
| 16.2.4 | get_stream_of_file | 파일로부터 스트림 얻기 |
| 16.2.5 | get_stream_of_directory | 디렉토리로부터 스트림 얻기 |