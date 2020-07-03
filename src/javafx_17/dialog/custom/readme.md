#### 커스텀 다이얼로그

다양한 스타일의 다이얼로그를 사용할 수 있는데, 이를 사용하려면 `Stage`로 직접 생성하면 된다.

아래와 같이 작성해서 생성할 수 있다.

```java
Stage dialog = new Stage(StageStyle.UTILITY);
dialog.initModality(Modality.WINDOW_MODAL);
dialog.initOwner(primaryStage);
```

Stage 생성자 매개값에는 윈도우 스타일을 결정짓는 `StageStyle` 열거 상수가 온다.

| StageStyle 열거 상수 | 설명 |
| --- | --- |
| DECORATED | 일반적인 윈도우 스타일 (기본값) |
| UNDECORATED | 배경이 흰색, 제목줄 없음 |
| TRANSPARENT | 배경이 투명, 제목줄 없음 |
| UNIFIED | DECORATED와 동일하나, 내용에 경계선이 없음 |
| UTILITY | 배경이 흰색이고, 제목줄에 타이틀, 종료 버튼만 있음 |

`initModality(Modality.WINDOW_MODAL)` : `모달 다이얼로그`로 설정한다. (없으면 `모달리스`로 생성된다.)

`initOwner(primaryStage)` : `소유자 원도우`를 설정한다.