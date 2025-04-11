import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Person implements Comparable<Person> {
    private String firstName,lastName;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private SortedSet<Person> children;

    public Person(String firstName, String lastName, LocalDate birthDate) {
        this(firstName, lastName, birthDate, null);
    }
    public Person(String firstName, String lastName, LocalDate birthDate, LocalDate deathDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
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
                ", birthDay=" + birthDate +
                ", deathDay=" + deathDate +
                ", children=" + children +
                '}';
    }

    public Person getYoungestChild(){
        if(children.isEmpty()) return null;

        return children.last();
    }

    @Override
    public int compareTo(Person o) {
         return this.birthDate.compareTo(o.birthDate);
    }

    public List<Person> getChildren(){
        return List.copyOf(children);
    }

    public String name(){
        return this.firstName + " " + this.lastName;
    }

    public static Person fromCsvLine(String line) throws NegativeLifespanException {
        String[] tokens = line.split(",");
        String[] nameTokens = tokens[0].split(" ");
        String firstName = nameTokens[0];
        String lastName = nameTokens[1];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate birthDate = !tokens[1].isEmpty() ? LocalDate.parse(tokens[1], formatter) : null;
        LocalDate deathDate = !tokens[2].isEmpty() ? LocalDate.parse(tokens[2], formatter) : null;
        Person person = new Person(firstName,lastName,birthDate,deathDate);
        if(birthDate != null && deathDate != null){
            if(birthDate.isAfter(deathDate)){
                throw new NegativeLifespanException(person);
            }
        }
        return person;
    }
    public static List<Person> fromCsv(String path)
    {
        try {
            ArrayList<Person> people = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(path));
            reader.readLine();
            String line;
            while((line = reader.readLine())!=null)
            {
                try {
                    Person newPerson = fromCsvLine(line);
                    for(Person existingPerson : people){
                        if(existingPerson.name().equals(newPerson.name())){
                            throw new AmbiguousPersonException(existingPerson, newPerson);
                        }
                    }
                    people.add(newPerson);
                } catch (NegativeLifespanException | AmbiguousPersonException e) {
                    System.err.println(e.getMessage());
                }
            }
            return people;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
