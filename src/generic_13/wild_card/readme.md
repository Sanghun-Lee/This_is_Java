### 와일드 카드

제네릭 변수를 리턴 타입이나 매개변수로 사용할 때 타입 파라미터를 제한하는 목적으로 사용한다.

(<T extends 상위 클래스>는 제네릭 메소드를 선언할 때 제한한다.)

만약 아래와 같이 상속된 상태인 경우

`A <- B <- C <- D <- E` (B extends A), (C extends B) ...

`<? extends C>` 라고 선언한 경우 `C, D, E`만 매개변수 또는 타입 파라미터에 올 수 있고

`<? super C>` 라고 선언한 경우 `A, B, C`만 매개변수 또는 타입 파라미터로 올 수 있다.


전체 코드의 상속 구조를 살펴보면

Person <- Student <- HighStudent

Person <- Worker

로 되어있다.

소스코드를 살펴보면

Course.java 파일을 보면 제네릭 타입 T로 선언하였다.

그리고 T 만큼 배열도 만들고 했다.

그 다음으로 `WildCardExample.java` 파일을 보면 `main`함수에서 부터

21번줄 ~ 39번 줄까지 `Person`, `Worker`, `Student`, `HighStudent`를 주어서 Course 객체를 생성 했다.

> 만약에 여기서 Course를 생성할 때 제네릭에 들어가는 클래스를 제한하고 싶을 때, Course 에서 <T extends ... > 를 사용한다.

아무튼 이렇게 제네릭 타입에 4개의 다른 클래스르 대입해서 4개의 Course 객체를 생성 했다.

`personCourse`, `workerCourse`, `studentCourse`, `highStudentCourse`

다음으로는 WildCardExample.java 에 3 개의 메서드가 존재한다.

1. registerCourse(Course 객체)
2. registerCourseStudent(Course 객체)
3. registerCourseWorker(Course 객체)

3개 메서드 모두 Course 객체를 필요로 하는데, 이 Course 객체를 생성할 때, **사용했던 제네릭 class 를 제한하고 싶을 때** 와일드 카드를 사용한다.

그래서 먼저 6번 줄에 나오는 메소드는

**void registerCourse(Course<?> course)** 로 되어있다.

? (물음표) 만 적으면 모든 Course 객체를 다 받겠다는 이야기 이다.

그래서 `registerCourse` 메소드의 매개변수로 올 수 있는 Course 객체 변수로는

1. personCourse (T에게 Person 타입을 주어서 객체 생성)
2. workerCourse (T에게 Worker 타입을 주어서 객체 생성)
3. studentCourse (T에게 Student 타입을 주어서 객체 생성)
4. highStudentCourse (T에게 HighStudent 타입을 주어서 객체 생성)

이 올 수 있다.

---

두 번째 메소드를 살펴보면

**void registerCourseStudent(Course<? extends Student> course)** 로 되어있다.

? extends "..." 로 적혀있으면 **"..."을 extends 한 클래스**를 제네릭에 전달해 준 Course 객체만 매개변수로 들어갈 수 있다.

그래서 `registerCourseStudent` 메소드의 매개변수로 올 수 있는 Course 객체 변수로는

1. ~~personCourse (T에게 Person 타입을 주어서 객체 생성)~~
2. ~~workerCourse (T에게 Worker 타입을 주어서 객체 생성)~~
3. studentCourse (T에게 Student 타입을 주어서 객체 생성)
4. highStudentCourse (T에게 HighStudent 타입을 주어서 객체 생성)

3, 4번 두 개만 올 수 있다.

---

세 번째 메소드를 살펴보면

**void registerCourseWorker(Course<? super Worker> course)** 로 되어있다.

? super "..." 로 적혀 있으면 **"..."의 상위 클래스들**을 제네릭으로 전달해 준 Course 객체만 매개변수로 들어갈 수 있다.

그래서 `registerCourseWorker` 메소드의 매개변수로 올 수 있는 Course 객체 변수로는

1. personCourse (T에게 Person 타입을 주어서 객체 생성)
2. workerCourse (T에게 Worker 타입을 주어서 객체 생성)
3. ~~studentCourse (T에게 Student 타입을 주어서 객체 생성)~~
4. ~~highStudentCourse (T에게 HighStudent 타입을 주어서 객체 생성)~~

1, 2번 두 개만 올 수 있다.
