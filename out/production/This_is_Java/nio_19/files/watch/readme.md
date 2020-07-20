#### 와치 서비스 (watchService)

와치 서비스란 디록토리 내부의 `파일 변화`(파일 생성, 삭제, 수정...)를 감시하는데 사용하는 서비스이다.

- WatchService 생성

```java
WatchService watchService = FileSystems.getDefault().newWatchService();
```

`WatchService`를 생성했다면, 감시가 필요한 디렉토리 `Path 객체`에서 `register()` 메소드로 WatchService를 등록하면 된다.

이 때 어떤 변화를 감시할 것인지를 enum 상수로 `register()`의 매개변수로 주면 된다.

```java
path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, ...MODIFT, ...DELETE);
```

위와 같이 path의 watchService를 등록한 이후에, 내부에서 변경이 일어나면, `WatchEvent`가 발생하고,

해당 이벤트 정보를 가진 `WatchKey`를 생성하여 `Queue`에 넣어준다.

프로그램은 WatchService의 `take()` 메소드를 호출하여 WatchKey를 얻어 처리하면 된다.

```java
while(true) {
    WatchKey watchKey = watchService.take();    // 큐에 WatchKey가 들어올 때 까지 대기
}
```

그 후, `pollEvents()` 메소드를 호출해서 WatchEvent 리스트를 얻어낸다.

여러개의 파일이 동시에 삭제, 수정, 생성이 될 수 있으니 `List`형태로 리턴해 준다.

`List<WatchEvent<?>> list = watchKey.pollEvents();`

- WatchService 종료

한 번 사용한 WatchKey는 `reset()` 메소드로 초기화 시켜 주어야 한다.

WatchService의 `close()`메소드를 이용하면 WatchService가 종료된다.

WatchService가 종료되면 WatchKey의 `reset()` 메소드는 `false`를 리턴한다.

`watchService.close();`