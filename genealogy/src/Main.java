import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Person person = new Person("Adam","Nowak",LocalDate.of(2000,5,21));
//        List<Person>people = new ArrayList<>();
//        people.add(person);
//        people.add(new Person("Pawel","Kowalski",LocalDate.of(2003,2,10)));
//        for (Person value : people) {
//            System.out.println(value);
//        }
        Person person = new Person("Adam","Nowak",LocalDate.of(2000,5,21));
        Person child = new Person("Pawel","Kowalski",LocalDate.of(2003,2,10));
        Person child1 = new Person("Jan","Nowak",LocalDate.of(2010,6,13));
        Person child2 = new Person("Dan","Nowak",LocalDate.of(2015,7,18));
        Person child3 = new Person("Gan","Nowak",LocalDate.of(2020,8,25));
        person.adopt(child);
        person.adopt(child1);
        person.adopt(child2);
        person.adopt(child3);
       // System.out.println(person.getYoungestChild());
        //System.out.println(person.getChildren());
//        for(var p: person.getChildren()) System.out.println(p);
        Family family = new Family();
        family.add(person, child, child1, child2, child3);
        //family.add(child);
        System.out.printf("%s",family.get("Adam Nowak"));
    }
}
