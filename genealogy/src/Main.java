import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //String csvLine = "Marek Kowalski,15.05.1899,25.06.1957,,";
        //Person person = Person.fromCsvLine(csvLine);
        //System.out.println(person.generateTree());
        PlantUMLRunner.setJarPath("./plantuml-1.2025.2.jar");
        try {
            List<Person> people = Person.fromCsv("family.csv");
            PlantUMLRunner.generate(
                    Person.generateTree(people,
                            person -> Person.sortByLifespan(people).contains(person),
                            //person -> Person.findOldestLiving(people) == person,
                            text -> text + " #FFFF00"),
                    "image_output", "all"

            );
            for (Person person : people) {
                System.out.println(person.generateTree());
                PlantUMLRunner.generate(person.generateTree(), "image_output", person.getName());
            }
            //Person.filterByName(people, "Kowalsk").forEach(System.out::println);
//            Person.sortedByBirth(people).forEach(System.out::println);
//            Person.sortByLifespan(people).forEach(System.out::println);
            System.out.println(Person.findOldestLiving(people));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NegativeLifespanException e) {
            throw new RuntimeException(e);
        }
    }
}