package collection_framework_15.comparable.implements_;

// TreeSet 과 TreeMap 은 대입 되자마자 정렬되기 때문에 정렬의 기준이 필요하다.
// Integer, String, Double 등은 compareTo 메소드가 있어서 상관업시만, 사용자 지정 클래스는 compareTo를 필요로 한다.
// Comparable을 구현한 객체를 TreeSet/TreeMap 에 사용한다.

public class Person implements Comparable<Person> {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person person) {
        if(age < person.age)
            return -1;
        else if(age == person.age) return 0;
        else return 1;
    }

    public void print() {
        System.out.println(this.name + " : " + this.age);
    }
}
