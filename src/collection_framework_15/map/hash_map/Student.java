package collection_framework_15.map.hash_map;

public class Student {
    public int sno;
    public String name;

    public Student(String name, int sno) {
        this.name = name;
        this.sno = sno;
    }

    @Override
    public int hashCode() {
        return sno + name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Student) {
            Student student = (Student) obj;
            return (this.sno == student.sno && this.name.equals(student.name));
        } else {
            return false;
        }
    }
}
