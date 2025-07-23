import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
public class Nianling {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 10));
        people.add(new Person("Bob", 15));
        people.add(new Person("Charlie", 25));
        people.add(new Person("ice", 22));
        people.sort((p1,p2)->p1.getAge().compareTo(p2.getAge()));
       

        for (Person person : people) {
            System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
        }
    }
}