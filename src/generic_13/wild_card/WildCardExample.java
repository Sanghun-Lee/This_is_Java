package generic_13.wild_card;

import java.util.Arrays;

public class WildCardExample {
    public static void registerCourse(Course<?> course) {
        System.out.println((course.getName() + " 수강생 : " + Arrays.toString(course.getStudents())));
    }

    // Student class 의 하위 타입 클래스만 올 수 있다. (Student, HighStudent)
    public static void registerCourseStudent(Course<? extends Student> course) {
        System.out.println(course.getName() + " 수강생 : " + Arrays.toString(course.getStudents()));
    }

    // Worker class 의 상위 타입 클래스만 올 수 있다. (Worker, Person)
    public static void registerCourseWorker(Course<? super Worker> course) {
        System.out.println(course.getName() + " 수강생 : " + Arrays.toString(course.getStudents()));
    }

    public static void main(String[] args) {
        // Course 를 Person 으로 생성
        Course<Person> personCourse = new Course<>("일반인 과정", 5);
        personCourse.add(new Person("일반인"));
        personCourse.add(new Person("직장인"));
        personCourse.add(new Student("학생"));
        personCourse.add(new HighStudent("고등학생"));

        // Course 를 Worker 로 생성
        Course<Worker> workerCourse = new Course<>("직장인 과정", 5);
        workerCourse.add(new Worker("직장인"));

        // Course 를 Student 로 생성
        Course<Student> studentCourse = new Course<>("학생 과정", 5);
        studentCourse.add(new Student("학생"));
        studentCourse.add(new HighStudent("고등학생"));

        // Course 를 HighStudent 로 생성
        Course<HighStudent> highStudentCourse = new Course<>("고등학생과정", 5);
        highStudentCourse.add(new HighStudent("고등학생"));

        // 모든 과정 등록
        registerCourse(personCourse);
        registerCourse(workerCourse);
        registerCourse(studentCourse);
        registerCourse(highStudentCourse);
        System.out.println();

        // 학생 과정만 등록
        // registerCourseStudent(personCourse);
        // registerCourseStudent(workerCourse);
        registerCourseStudent(studentCourse);
        registerCourseStudent(highStudentCourse);
        System.out.println();

        // 직장인과 일반인 과정만 등록
        registerCourseWorker(personCourse);
        registerCourseWorker(workerCourse);
        // registerCourseWorker(studentCourse);
        // registerCourseWorker(highStudentCourse);
        System.out.println();
    }
}
