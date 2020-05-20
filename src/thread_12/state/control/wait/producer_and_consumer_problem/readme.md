### 생산자 소비자 문제

DataBox class에 setData와 getData메소드가 선언되어 있다.

setData는 생산자인 ProducerThread가 호출하는 메소드이고.

getData는 소비자인 ConsumerThread가 호출하는 메소드이다.

생산자인 ProducerThread가 setData를 호출할 때, data가 null이 아니면 wait 상태에 들어가고,

null이면 데이터 저장 후, 소비자인 ConsumerThread를 notify 메소드로 재 가동 시킨다.

소비자인 ConsumerThread가 getData를 호출할 때, data가 null이면 wait 상태에 들어가고

null이 아니면, 데이터 출력 후, null로 만들어준다. 그리고 생산자인 ProcuderThread를 notify 메소드로 재 가동 시킨다.
 