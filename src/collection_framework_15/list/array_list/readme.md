### ArrayList

1.  ArrayList 객체 생성 방법

- ArrayList<T> arraylist = new ArrayList<T>();
- List<T> list = new ArrayList<T>();

ArrayList는 인터페이스 List의 구현 객체이기 때문에 아래와 같은 방법으로 ArrayList를 생성할 수 있다.

생성시에 괄호안에 아무 값을 쓰지 않으면 16개의 초기 용량으로 생성된다.

2. 초기 용량을 설정해서 객체 생성

- List<T> list = new ArrayList<T>(`int capacity`);

3. 삽입

- list.add(`T value`);

add 메소드를 이용해서 list의 제일 뒤에 값을 추가한다.

- list.add(int index, `T value`);

index위치에 value를 추가한다.

4. 객체를 얻는 방법

- list.get(int index);

index위치의 객체를 리턴한다.

5. 객체 삭제 방법

- list.remove(`T object`);

`object`와 같은 값을 삭제한다.

- list.remove();

가장 뒤에 있는 값을 삭제한다.

- list.remove(int index);

index 위치의 값을 삭제한다.
