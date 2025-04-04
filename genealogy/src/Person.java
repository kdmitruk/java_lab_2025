import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Person {
    private String firstName,lastName;
    private LocalDate birthDay;
    private Set<Person> children;

    public Person(String firstName, String lastName, LocalDate birthDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.children = new HashSet<>();
    }
    public boolean adopt(Person child)
    {
        return this.children.add(child);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDay=" + birthDay +
                ", children=" + children +
                '}';
    }
}
