import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.Map;

class Person {
    String name;
    int age;
    String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age
                ;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age && name==person.name && gender.equals(person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}



public class Stream {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 30, "female"),
                new Person("Alice", 30, "female"),
                new Person("Bob", 25, "male"),
                new Person("Luyikong", 10, "male"),
                new Person("Lucy", 22, "female") // Duplicate name to test deduplication

        );

        List<Person>first = people.stream().filter(p -> p.name.startsWith("Lu")).limit(1).collect(Collectors.toList());
        System.out.println(first);
        List<Person>Second = people.stream().filter(p -> p.name.startsWith("Lu")&& p.age > 18).collect(Collectors.toList());
        System.out.println(Second);

        Map<String, Long> genderCounts = people.stream().distinct()
                .collect(Collectors.groupingBy(p -> p.gender, Collectors.counting()));
        people.stream().distinct().forEach(b -> System.out.println(b));
        System.out.println(genderCounts);
        Map<String, Long> ageGroupsByGender = people.stream().distinct()
                .map(p -> p.gender + "-" + (p.age / 10)).collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        System.out.println(ageGroupsByGender);

    }
}