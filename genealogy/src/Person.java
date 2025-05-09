import java.io.*;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Person implements Comparable<Person>, Serializable {
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
    public void addChild(Person child) {
        children.add(child);
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
            Map<String, PersonWithParentStrings> peopleWithParentStrings = new HashMap<>();
            BufferedReader reader = new BufferedReader(new FileReader(path));
            reader.readLine();
            String line;
            while((line = reader.readLine())!=null)
            {
                try {
                    // Person newPerson = fromCsvLine(line);
                    PersonWithParentStrings newPerson = PersonWithParentStrings.fromCsvLine(line);
                    /*for(Person existingPerson : peopleWithParentStrings){
                        if(existingPerson.name().equals(newPerson)){
                            throw new AmbiguousPersonException(existingPerson, newPerson);
                        }
                    }*/
                    peopleWithParentStrings.put(newPerson.person.name(), newPerson);
                } catch (NegativeLifespanException/* | AmbiguousPersonException*/ e) {
                    System.err.println(e.getMessage());
                }
            }
            PersonWithParentStrings.linkRelatives(peopleWithParentStrings);
            List<Person> result = new ArrayList<>();
            for(PersonWithParentStrings personWithStrings: peopleWithParentStrings.values())
                result.add(personWithStrings.person);
            return result;
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

    public static void toBinaryFile(List<Person> people, String path) throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(people);

        oos.close();
    }
    public static List<Person> fromBinaryFile(String path) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Person> people = null;
        try {
            people = (ArrayList<Person>) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ois.close();
        return people;
    }
    public String toUML(){
        Function<Person, String> personToUmlObject = (person) -> {
            StringBuilder builder = new StringBuilder();
            builder.append(String.format("object \"%s\" {\n", person.name()));
            builder.append(String.format("birth = %s", person.birthDate));
            builder.append("\n}\n");
            return builder.toString();
        };
        Function<Person, String> personToNameWithQuotation = person -> String.format("\"%s\"",person.name());
        BiFunction<Person, Person, String> arrowBetweenPeople = (parent, child) -> personToNameWithQuotation.apply(parent)+"-->"+personToNameWithQuotation.apply(child);
        StringBuilder builder = new StringBuilder();
        builder.append("@startuml\n");
        builder.append(personToUmlObject.apply(this));
        //children.forEach(person -> builder.append(personToUmlObject.apply(person)));
        String childrenString = children.stream()
                        .map(personToUmlObject)
                        .collect(Collectors.joining());
        builder.append(childrenString);
        String arrowString = children.stream()
                .map(child->arrowBetweenPeople.apply(this, child))
                .collect(Collectors.joining("\n"));
        builder.append(arrowString);
        builder.append("\n@enduml\n");
        return builder.toString();
    }


}
