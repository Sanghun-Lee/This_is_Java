#### 미디어 컨트롤

미디어 컨트롤은 비디오 재생을 위한 

- MediaView
- Slider
- ProgressBar, ProgressIndicator

가 있다.

`MediaView`는 비디오가 표시 될 위치만 표시한다.

`<MediaView fitHeight="200.0" fitWidth="300" preserveRatio="false" />`

비디오를 재생하려면 `MediaPlayer`가 있어야 한다.

예시 코드

```java
Media media = new Media("미디어 소스 경로");
MediaPlayer mediaPlayer = new MediaPlayer(media);
```

`MediaPlayer`는 `Media` 객체 형태로 전달해서 다음과 같이 생성한다.

비디오의 경우 아래 코드로 `MediaPlayer` 객체를 등록해야 한다.

`mediaView.setMediaPlayer(mediaPlayer);`

##### MediaPlayer의 상태

MediaPlayer의 상태는 아래와 같다.

- UNKNOWN (unknown)
- READY (ready) : 준비 완료 상태
- PAUSE (pause) : 일시정지
- PLAYING (playing) : 재생 중
- STALLED (stalled) : 버퍼링 중
- STOPPED (stopped) : 정지상태
- EndOfMedia : 미디어가 끝난 경우

`setOnXXX(Runnable r)` : XXX 상태일 때 해당 Runnable 구현 객체를 실행한다.

아래 예시 코드는

`Ready`상태일 때 현재 시간에 대한 속성 감시를 시작하고, 리스너를 설정해서 시간이 바뀔 때 마다 change 메소드를 실행시킨다.

```java
mediaPlayer.setOnReady(new Runnable() {
    @Override
    public void run() {
        mediaPlayer.currentTimeProperty().addListener((observable, oldValue, newValue) -> {
            // 재생 시간을 표시하는 코드
        });
    }
});
```