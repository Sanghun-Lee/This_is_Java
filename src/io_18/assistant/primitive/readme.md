#### 기본 타입 입출력 보조 스트림

자바의 기본 타입 `double`, `int`, `long`, `float` 단위로 입출력 하기 위해선

`DataInputStream`, `DataOutputStream`을 이용해야 한다.

> 객체 생성 코드

```java
DataInputStream dis = new DataInputStream(바이트 입력 스트림);
DataOutputStream dos = new DataOutputStream(바이트 출력 스트림);
```

DataInputStream, DataOutputStream의

- boolean 읽기, 쓰기
    - readBoolean()
    - writeBoolean(boolean v)
    
- int 읽기, 쓰기
    - readInt()
    - writeInt(int v)
    
- String 읽기, 쓰기
    - readUTF()
    - writeUTF(String str)
    
`DataOutputStream`으로 쓴 데이터는

`DataInputStream`으로 읽을 때 `쓴 순서대로` 읽어야 한다.

