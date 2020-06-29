package stream_16.parallel;

public class Student {
    public enum Sex { MALE, FEMALE }
    public enum City { Seoul, Pusan }

    private String name;
    private int score;
    private Student.Sex sex;
    private Student.City city;

    public Student(String name, int score, Student.Sex sex) {
        this.name = name;
        this.score = score;
        this.sex = sex;
    }

    public Student(String name, int score, Student.Sex sex, Student.City city) {
        this.name = name;
        this.score = score;
        this.sex = sex;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public Student.Sex getSex() {
        return sex;
    }

    public Student.City getCity() {
        return city;
    }
}
