import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person person = Person.fromCsvLine("Marek Kowalski,15.05.1899,25.06.1957,,");
        System.out.println(person);
        List<Person> people = Person.fromCsv("family.csv");
        System.out.println(people);

    }
}
