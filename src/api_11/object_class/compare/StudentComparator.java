package api_11.object_class.compare;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        if(a.sno < b.sno)
            return -1;
        else if(a.sno == b.sno)
            return 0;
        else
            return 1;

        // 위 코드는 아래 코드와 같은 역할을 한다.
        // return Integer.compare(a.sno, b.sno);
    }
}

class Student {
    int sno;
    public Student(int sno) {
        this.sno = sno;
    }
}