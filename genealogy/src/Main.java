import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person parent = new Person("Adam","Nowak",LocalDate.of(2000,5,21));
        Person child = new Person("Pawel","Kowalski",LocalDate.of(2003,2,10));
        Person child1 = new Person("Jan","Nowak",LocalDate.of(2010,6,13));
        Person child2 = new Person("Jan","Nowak",LocalDate.of(2015,7,18));
        Person child3 = new Person("Jan","Nowak",LocalDate.of(2020,8,25));
        Family family = new Family();
        family.add(parent, child, child1, child2, child3);
        Person[] people = family.get("Jan Nowak");
        if(people!=null)
            for(Person person : people) {
                System.out.println(person);
            }
    }
}
