#### System.out 필드

콘솔에서 데이터를 출력하기 위해서는 `System 클래스`의 `out 정적 필드`를 사용한다.

out은 `PrintStream`타입의 필드이다.

PrintStream은 OutputStream의 하위 클래스 이기 때문에 OutputStream타입으로 변환해서 사용할 수 있다.

`OutputStream outputStream = System.out;`

OutputStream은 byte 단위로 쓰고, `write(int b)`메소드를 이용하면 1byte 콘솔에 출력된다.

한글을 출력하기 위해선 `write(byte[] b)` 또는 `write(byte[] b, int offset, int len)`을

이용해서 출력할 수 있다.