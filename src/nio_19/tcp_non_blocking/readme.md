#### TCP NonBlocking channel

자바의 non-blocking 방식은 `connect()`, `accept()`, `read()`, `write()` 메소드에서 blocking이 없다.

accept()는 연결요청이 없으면 바로 null을 리턴한다.

read()는 클라이언트가 데이터를 보내지 않으면 0을 리턴한다.

그래서 다음과 같이 코드를 작성하면 무한루프를 돌기 때문에 주의해야 한다.

```java
while(true) {
    SocketChannel socketChannel = serverSocketChannel.accept();
    // ...
}
```

그래서 non-blocking은 이벤트 리스너 역할을 하는 `Selector`를 사용한다.

책에는 아래와 같이 작성되어 있다.

> non-blocking channel은 Selector를 등록해 놓으면
>
> 클라이언트의 연결 요청이 들어오거나 데이터가 도착할 경우,
>
> 채널은 Selector에 통보한다.
>
> Selector는 통보한 채널들을 선택해서 작업 스레드가 accept() 또는 read()메소드를 실행해서
>
> 즉시 작업을 처리하도록 한다.

Non-blocking은 연결 요청이 들어왔거나, 데이터가 들어오면 처리 작업을 하기 때문에,

싱글 스레드에서 이를 처리할 수 있다.

##### Selector의 동작 원리

사용자는 코드에서 작업 유형 `(write, read, accept.. )`을 **키(Selection Key)**로 생성한다.

해당 키를 Selector의 `관심키 셋(interest-set)`에 저장시킨다.

> 관심키 셋 : Set Collection 으로 이루어져 있다.

작업 준비가 완료되었으면 관심키 셋 에서 `선택된 키셋(selected-set)`에 별도로 저장한다.

그리고 작업 스레드는 선택된 키 셋 에 있는 키를 하나씩 꺼내서 해당 작업을 처리한다.

<br>
<img width="550" height="300" src="https://t1.daumcdn.net/cfile/tistory/2268FF3555EBAC6923?download">
<br>

---

#### Selector 생성 및 등록

Selector는 정적 메소드인 `open()`메소드를 호출하여 생성한다. 해당 메소드는 예외 처리가 필요하다.

```java
try {
    Selector selector = Selector.open();
} catch(IOException e) {}
```

> Selector에 등록할 수 있는 채널은 SelectableChannel의 하위 채널만 가능하다.

ServerSocketChannel과 SocketChannel을 Selector에 등록하기 위해서는 `non-blocing`으로 설정해야 한다.

```java
ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
serverSocketChannel.configureBlocking(false);

SocketChannel socketChannel = SocketChannel.open();
socketChannel.configureBlocking(false);
```

각 채널은 `register()` 메소드를 이용해서 `Selector에 등록`한다.

`첫 매개값은 Selector`이고, `두 번째 매개값은 채널의 작업 유형`이다.

```java
// 해당 서버 채널을 Selector에 등록
SelectionKey selectionKey = serverSocketChannel.register(Selector sel, int ops);

// 해당 클라이언트 채널은 Selector에 등록
SelectionKey selectionKey = socketChannel.register(Selector sel, int ops);
```

register() 메소드는 채널과 작업 유형 정보를 담고있는 SelectionKey를 생성하고, Selector의 관심키셋에 저장한 후, 해당 `SelectionKey`를 리턴한다.

해당 코드는 SercerSocketChannel의 Selector에 자신의 작업 유형을 등록하는 코드이다.

```java
SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
```

여기서 주의할 점은 **동일한 SocketChannel로 두 가지 이상의 작업 유형을 등록할 수 없다.**

즉, `register()` 메소드는 두 번 이상 호출할 수 없다.

작업 유형을 변경하려면 이미 생성된 `SelectionKey`를 수정해야 한다.

register()가 리턴한 SelectionKey는 작업 유형 변경, 첨부 객체 저장, 채널 등록 취소 등을 할 때 사용된다.

SelectionKey 객체는 `keyFor(Selector sel)` 메소드로 얻을 수 있다. (그래서 따로 관리할 필요가 없다.)

```java
SelectionKey key = socketChannel.keyFor(selector);
```

---

#### 선택된 키셋

Selector를 구동하려면 `select()` 메소드를 호출해야 한다.

- select()
    
select() 메소드는 관심키 셋에 저장된 SelectionKey로부터 작업 처리 준비가 되었다는 통보가 올 때 까지

`(선택된 키 셋에 키가 올 때 까지) blocking`한다.

그리고 최소한 하나의 `SelectionKey로 부터 작업 처리 준비가 완료되었다면 리턴`한다.

작업 유형을 변경하려면 해당 selectionKey의 `intersetOps()` 메소드를 호출해서 변경한다.

```java
selectionKey.interestOps(SelectionKey.OP_WRITE);
selector.wakeup();
```

SelectionKey의 작업 유형이 변경되면 Selector의 wakeup() 메소드를 호출해서 blocking 되어있는

select()를 즉시 리턴하고, `변경된 작업 유형을 감지하도록 select()를 다시 실행`해야 한다.

select() 메소드가 1 이상의 값을 리턴할 때 `selectedKeys()` 메소드로 작업 처리 준비된

SelectionKey들을 `Set 컬렉션`으로 얻는다.

```java
int keyCount = selector.select();
if(keyCount > 0) {
    Set<SelectionKey> selectedKeys = selector.selectedKeys();
}
```

---

#### 채널 작업 처리

작업 스레드가 해야 할 일은 선택된 키셋에서 `SelectionKey`를 하나씩 꺼내어 작업 유형별로 채널 작업을 처리하는 것이다.

작업 유형을 알아내는 방법은 다음 메소드를 사용하면 된다.

| return type | method name | description |
| --- | --- | --- |
| boolean | isAcceptable() | 작업 유형이 OP_ACCEPT인 경우 |
| boolean | isConnectable() | 작업 유형이 OP_CONNECT인 경우 |
| boolean | isReadable() | 작업 유형이 OP_READ인 경우 |
| boolean | isWritable() | 작업 유형이 OP_WRITE인 경우 |

아래 코드는 작업 유형별로 채널 작업을 처리하는 코드이다.

```java
Thread thread = new Thread() {
    @Override
    public void run() {
        while(true) {
            try {
                int keyCount = selector.select();   // 작업 처리 준비된 키 감지
                if(keyCount == 0) { continue; }     // 키가 없을 경우 루프 처음으로 돌아감
                Set<SelectionKey> selectedKeys = selector.selectedKeys();   // 선택된 키 셋 얻기
                Iterator<SelectionKey> iterator = selectedKeys.iterator();  // 반복자 얻기
                while(iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();    // 키를 하나씩 꺼내옴
                    if(selectionKey.isAcceptable()) { /* 연결 수락 작업 처리 */ }
                    if(selectionKey.isReadable()) { /* 읽기 작업 처리 */ }
                    if(selectionKey.isWritable()) { /* 쓰기 작업 처리 */ }
                    iterator.remove();  // 완료된 SelectionKey 제거
                }
            } catch(Exception e) {
                break;
            } 
        }
    }
};
thread.start();
```

채널 객체의 경우 `SelectionKey`의 `channel()`메소드를 호출하면 얻을 수 있다.

작업 유형이 OP_ACCEPT일 경우 `ServerSocketChannel`이기 때문에 ServerSocketChannel 객체를 얻는 코드이다.

```java
ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
```

채널 객체 이외에 다른 객체가 필요할 수 있다.

이럴때에는 `SelectionKey`에 첨부해 두고, 사용할 수 있다.

SelectionKey의 `attach()` 메소드는 객체를 첨부하고, `attachment()` 메소드는 첨부된 객체를 얻는데 사용된다.

```java
// 객체 첨부하기
Client client = new Client(socketChannel);
SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_READ);
selectionKey.attach(client);

// 첨부된 객체 얻기
if (selectionKey.isReadable()) {
    Client client = (Client) selectionKey.attachment();
    // ...
}
```