### 입력 스트림과 출력 스트림

프로그램이 데이터를 입력받을 때에는 `입력 스트림(InputStream)`이라 부르고,

프로그램이 데이터를 보낼 때에는 `출력 스트림(OutputStream)`이라 부른다.

항상 기준은 `프로그램`이고, 프로그램 기준으로 데이터가 들어오면 입력 스트림이다.

---

스트림의 종류는 크게 두 종류로 구분된다.

1. byte 기반 스트림
2. 문자 기반 스트림

문자 기반 스트림은 오직 문자만 받고 보낼 수 있고, byte 기반은 이미지, 그림등 모든 파일을 처리할 수 있다.

> byte 기반 스트림

byte 기반 입력 스트림의 최상위 클래스를 `InputStream`이고,

byte 기반 출력 스트림의 최상위 클래스는 `OutputStream`이다.

> 문자 기반 스트림

문자 기반 입력 스트림의 최상위 클래스는 `Read` 이고,

문자 기반 출력 스트림의 최상위 클래스는 `Write` 이다.

---

#### InputStream

InputStream은 byte 기반 입력 스트림의 최상위 클래스로, 추상 클래스 이다.

InputStream을 상속하는 클래스로는 `BufferedInputStream`, `DataInputStream`, `FileInputStream`이 있다.

InputStream에서 사용할 수 있는 메소드는 다음과 같다.

- int read()
    - 입력 스트림으로부터 1바이트를 읽고 읽은 바이트를 리턴한다.
    - 리턴된 int 4byte중에 `끝의 1byte에만` 데이터가 들어가 있다.
    
- int read(byte[] b)
    - 입력 스트림으로부터 읽은 바이트를 매개변수 b에 저장하고, 실제 읽은 바이트 수를 리턴한다.
    
- int read(byte[] b, int offset, int len)
    - 입력 스트림으로부터 len개의 바이트만큼 읽고, 매개변수 b[offset]부터 len개까지 저장한다. 실제로 읽은 바이트 수를 리턴한다.
    
- close()
    - InputSream을 더 이상 사용하지 않을시 `close() 메소드`로 `자원을 반환`해 준다. 

더 이상 입력 스트림으로부터 읽을 바이트가 없다면 해당 메소드들은 `-1`을 리턴한다.

그래서 다음과 같이 루프를 돌 수 있다.

```java
InputStream is = new FileInputStream("...");
int readByte;
while((readByte = is.read()) != -1) { ... }
```

---

#### OutputStream

OutputStream은 바이트 기반 출력 스트림의 최상위 클래스로 추상 클래스 이다.

OutputStream을 상속받는 클래스로는 `FileOutputStream`, `PrintStream`, `BufferedOutputStream`, `DataOutputStream`이 있다.

OutputStream에서 사용할 수 있는 메소드는 다음과 같다.

- void write(int b)
    - 출력 스트림으로 1바이트를 보낸다.
    - 매개변수 b의 4byte(`int형`) 중에 `끝 1byte만` 전송한다.
    
- void write(byte[] b)
    - 출력 스트림으로 매개변수 b의 모든 byte를 보낸다.
    
- void write(byte[] b, int offset, int len)
    - 출력 스트림으로 매개변수 b[offset]부터 len개 까지 데이터를 보낸다.
    
- void flush()
    - 버퍼에 잔류하는 모든 byte를 출력한다.
    
- void close()
    - 사용한 시스템 자원을 반납하고 출력 스트림을 닫는다.
    
예시

```java
OutputStream os = new FileOutputStream("...");
byte[] data = "ABC".getBytes();
os.write(data);
os.flush();
os.close();
```

---

#### Reader

Reader는 `문자 기반 입력 스트림`의 최상위 클래스로 추상 클래스이다.

Reader를 상속받는 클래스는 `FileReader`, `BufferedReader`, `InputStreamReader`가 있다.

Reader에서 사용할 수 있는 메소드는 다음과 같다.

- int read()
    - 입력 스트림에서 한 개의 문자를 읽고 리턴한다.
    - 문자는 2byte로 이루어져 있기 때문에, 리턴된 int값 중, 하위 2byte가 문자로 들어간다.
    
- int read(char[] charBuffer)
    - 입력 스트림으로부터 읽은 문자를 `charBuffer`에 저장하고, 읽은 문자 수를 리턴한다.
    
- int read(char[] charBuffer, int offset, int len)
    - 입력 스트림으로부터 읽은 문자를 charBuffer[offset]부터 len개 까지 저장한다.
    - 실제로 읽은 문자 수를 리턴한다.
    
- void close()
    - 사용한 시스템 자원은 반환한다.
    
Reader의 위 메소드도, InputStream의 메소드와 같이, 더 읽을 문자가 없다면 `-1`을 리턴한다.

예시

```java
Reader reader = new FileReader("...");
int readData;
while((readData = reader.read()) != -1) {
    char charData = (char) readData;
}
```

---

#### Writer

Writer는 문자 기반 출력 스트림의 최상위 클래스로 추상 클래스 이다.

Writer를 상속받는 클래스는 `FileWriter`, `BufferedWriter`, `PrintWriter`, `OutputStreamWriter`가 있다.

Writer에서 사용할 수 있는 메소드는 다음과 같다.

- void write(int c)
    - 출력 스트림으로 주어진 매개변수 c를 보낸다 (c의 끝 2byte)
    
- void write(char[] charBuffer)
    - 출력 스트림으로 `charBuffer`의 모든 문자를 보낸다.
    
- void write(char[] charBuffer, int offset, int len)
    - 출력 스트림으로 charBuffer[offset]부터 len개 만큼 보낸다.
    
- void write(String str), write(String str, int offset, int len)
    - 출력 스트림으로 매개변수 `str`을 보낸다.
    
- void flush()
    - 버퍼에 잔류하는 모든 문자열을 출력한다.
    
- void close()
    - 자원을 반납하고, 출력 스트림을 닫는다.
    
`write(char[] c, int offset, int len)` 예시

```java
Writer writer = new FileWriter("...");
char[] data = "홍길동".toCharArray();
writer.write(data, 1, 2);   // "길동"만 출력
```