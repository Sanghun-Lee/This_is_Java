#### 애니메이션

JavaFx에서 애니메이션은 컨트롤 또는 컨테이너의 `속성 변화를 주어진 시간동안 진행함`으로써 구현한다.

| 클래스 | 설명 |
| --- | --- |
| Timeline | KeyFrame에 설정된 내용대로 <strong>애니메이션을 진행시키는 객체</strong> |
| KeyValue | 타겟 속성(Property)과 종료값을 설정하는 객체 |
| KeyFrame | 애니메이션의 지속 시간과 KeyValue를 설정하는 객체 |

예시 코드

```java
Timeline timeline = new Timeline(); // 객체 생성
KeyValue keyValue = new KeyValue(parent.translateXProperty(), 종료값);
KeyFrame keyFrame = new KeyFrame(Duration.millis(지속시간), keyValue);
timeline.getKeyFrames().add(keyFrame);
timeline.play();    // 애니메이션 진행
```

> KeyValue keyValue = new KeyValue(parent.translateXProperty(), 종료값);
> 
> translateXProperty() 메소드로 값을 변화시킬 translateX 속성의 Property 객체를 얻고 
> 
> 종료값을 지정해서 KeyValue 객체를 생성한다.


> KeyFrame keyFrame = new KeyFrame(Duration.millis(지속시간), keyValue);
> 
> 애니메이션 지속 시간(ms)과 keyValue를 지정해서 KeyFrame을 생성한다.