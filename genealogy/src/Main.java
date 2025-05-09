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
        /*try {
            List<Person> people = Person.fromBinaryFile("people.bin");
            System.out.println(people);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        PlantUMLRunner.setJarPath(args[0]);
//        PlantUMLRunner.generate("@startuml\n" +
//                "\n" +
//                "object \"Jan Kowalski\" {\n" +
//                "  birth = 1.1.1970\n" +
//                "}\n" +
//                "\n" +
//                "object \"Anna Kowalska\" {\n" +
//                "  birth = 1.1.1990\n" +
//                "}\n" +
//                "\n" +
//                "\"Anna Kowalska\" --> \"Jan Kowalski\"\n" +
//                "\n" +
//                "@enduml\n", "uml", "test");
//    }
        List<Person> people = Person.fromCsv("family.csv");
        Family family = new Family();
        people.forEach(family::add);
        Person ewa = family.get("Ewa Kowalska")[0];
        PlantUMLRunner.generate(ewa.toUML(), "uml", "Ewa");
    }
}
