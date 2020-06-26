package stream_16.sorting;

// 해당 클래스에서 sorted 스트림을 사용하기 위해선 Comparable 인터페이스를 구현해야 한다.

public class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    // score < o.score  : 음수 리턴
    // score == o.score : 0 리턴
    // score > o.score  : 양수 리턴
    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.score, o.score);
    }
}
