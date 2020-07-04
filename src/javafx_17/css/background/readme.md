#### background 속성

background 속성은 컨테이너 및 컨트롤의 배경 스타일을 설정한다.

| 속성 | 설명 |
| --- | --- |
| -fx-background-color | 배경 색상 |
| -fx-background-image | 배경 이미지 |
| -fx-background-position | 배경 이미지 위치(top, right, bottom, left, center) |
| -fx-background-repeat | 이미지 반복 여부 (no-repeat : 반복하지 않음) |


`-fx-background-color`에는 선형 및 원형 그라데이션까지 넣을 수 있다.

> 선형 그라데이션

선언방법은 아래와 같다.

`linear-gradient(to 진행방향, 시작색 S%, 중간색 M%..., 끝색);`

사용 예시

`-fx-background-color: linear-gradient(to right, black, white);`

> 원형 그라데이션

선언 방법

`radial-gradient(center X% Y%, radius R%, 시작색 S%, 중간색 M%, 끝색);`

사용 예시

`-fx-background-color: radial-gradient(center 50% 50%, radius 50%, #ffffff 10%, #000000);`

> 이미지 반복

이미지 반복은 이미지가 화면에 모두 있지 않을 때 옆에 더 만들어 준다. (배경화면에 바둑판식 배경화면)