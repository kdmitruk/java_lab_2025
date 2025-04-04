import java.time.LocalDate;
import java.util.*;

import static java.util.List.copyOf;

public class Person implements Comparable<Person> {
    private String firstName,lastName;
    private LocalDate birthDay;
    private SortedSet<Person> children;

    public Person(String firstName, String lastName, LocalDate birthDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.children = new TreeSet<>();
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

    public Person getYoungestChild(){
        if(children.isEmpty()) return null;

        return children.last();
    }

    @Override
    public int compareTo(Person o) {
         return this.birthDay.compareTo(o.birthDay);
    }

    public List<Person> getChildren(){
        return List.copyOf(children);
    }

    public String name(){
        return this.firstName + " " + this.lastName;
    }
}
