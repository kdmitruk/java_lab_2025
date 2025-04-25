import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List<Person> people = Person.fromCsv("family.csv");
//        System.out.println(people);
//        try {
//            Person.toBinaryFile(people, "people.bin");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            List<Person> people = Person.fromBinaryFile("people.bin");
            System.out.println(people);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
