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
        System.out.println(person.adopt(child));
        System.out.println(person.adopt(child));
        System.out.println(person);
    }
}
