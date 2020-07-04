#### shadow 효과

그림자 효과를 주기 위해선 `-fx-effect`속성을 제공한다.

속성값으로는 다음 두 가지가 있다.

- dropshadow() : 바깥 그림자를 주어 튀어나오는 느낌을 준다.
- innershadow() : 안쪽 그림자를 주어 움푹 들어간 느낌을 준다.

작성 예시

```css
-fx-effect: dropshadow(three-pass-box, 그림자 색상, radius, spread, offsetX, offsetY);
-fx-effect: innershadow(three-pass-box, 그림자 색상, radius, choke, offsetX, offsetY);
```

`radius`의 기본값을 10이고, `spread, choke`의 기본값은 0.0 이다.

`three-pass-box`, `radius`, `spread`, `choke`는 그냥 기본값으로 주는것이 좋다.

`offsetX`, `offsetY`는 그림자의 편차이다.