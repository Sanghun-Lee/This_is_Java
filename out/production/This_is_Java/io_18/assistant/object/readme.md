#### 객체 입출력 보조 스트림

메모리에 생성된 `객체`를 네트워크 또는 파일로 보낼 수 있다.

객체는 문자가 아니기 때문에, `바이트 기반 스트림`으로 출력해야 한다.

객체를 출력하기 위해서는 객체의 `필드 값을 연속적인 바이트로 변경`해야 한다.

이를 `객체 직렬화(serialization)` 라고 한다.

전송된 연속적인 바이트를 객체로 변경할 수 있는데, 이를 `역직렬화(deserialization)`이라 한다.

> 직렬화 : 객체 >> 연속적인 바이트
>
> 역직렬화 : 연속적인 바이트 >> 객체

##### ObjectInputStream, ObjectOutputStream

자바는 객체를 입출력 할 수 있는 두 개의 메소드가 있다.

- `ObjectInputStream`
    - 객체를 직렬화 할 때 사용한다.
    
- `ObjectOutputStream`
    - 객체를 역직렬화 할 때 사용한다.
    
> 사용 방법

```java
ObjectInputStream ois = new ObjectIntputStream(바이트 입력 스트림);
ObjectOutputStream oos = new ObjectOutputStream(바이트 출력 스트림);
```

객체를 직렬화 하기 위해선 `ObjectOutputStream`의 `writeObject()` 메소드를 사용한다.

`oos.writeObject(객체)`

객체를 역직렬화 하기 위해선 `ObjectInputStream`의 `readObject()` 메소드를 사용한다.

그리고 해당 메소드의 리턴 타입은 `Obejct`이기 때문에 원래 객체 타입으로 변환해 주어야 한다.

`객체타입 변수이름 = (객체타입) ois.readObject();`