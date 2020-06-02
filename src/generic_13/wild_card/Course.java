package generic_13.wild_card;

public class Course<T> {
    private String name;
    private T[] students;

    public Course(String name, int capacity) {
        this.name = name;
        // 제네릭타입 배열은 아래와 같이 생성할 수 있다.
        students = (T[])(new Object[capacity]);
    }

    public String getName() {
        return this.name;
    }
    public T[] getStudents() {
        return this.students;
    }

    // 배열에 비어있는 부분을 찾아서 수강생을 추가해주는 메소드
    public void add(T t) {
        for(int i = 0; i < students.length; i++) {
            if(students[i] == null) {
                students[i] = t;
                break;
            }
        }
    }
}
