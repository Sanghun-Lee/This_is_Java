package stream_16.parallel;

import java.util.ArrayList;
import java.util.List;

public class MaleStudent  {
    private List<Student> list; // 남학생만 저장하는 private List

    // 생성자, List를 생성한다.
    public MaleStudent() {
        list = new ArrayList<Student>();
        System.out.println("[" + Thread.currentThread().getName() + "] MaleStudent()");
    }

    // Student 객체를 받아서 리스트에 추가한다.
    public void accumulate(Student student) {
        list.add(student);
        System.out.println("[" + Thread.currentThread().getName() + "] accumulate()");
    }

    // 병렬처리시에 사용
    // 다른 컨테이너를 매개값으로 받아서 본인이 가지고 있는 리스트를 결합한다.
    public void combine(MaleStudent other) {
        list.addAll(other.getList());
        System.out.println("[" + Thread.currentThread().getName() + "] combine()");
    }

    // getter
    public List<Student> getList() {
        return list;
    }
}