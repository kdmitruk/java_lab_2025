import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PersonWithParentStrings {
    public final Person person;
    private List<String> parents;
    public PersonWithParentStrings(Person person, List<String> parents) {
        this.person=person;
        this.parents=parents;
    }
    public static PersonWithParentStrings fromCsvLine(String line) throws NegativeLifespanException {
        Person person = Person.fromCsvLine(line);
        String[] tokens = line.split(",");
        List<String> parents = new ArrayList<String>();
        for(int i=3; i<5; i++){
            try {
                if (!tokens[i].isEmpty()) {
                    parents.add(tokens[i]);
                }
            }
            catch (ArrayIndexOutOfBoundsException _) {}
        }
        return new PersonWithParentStrings(person, parents);
    }
    public static void linkRelatives(Map<String, PersonWithParentStrings> peopleWithParentStrings) {
        for(PersonWithParentStrings parent: peopleWithParentStrings.values()) {
            Person person = parent.person;
            for(PersonWithParentStrings possibleChild: peopleWithParentStrings.values()) {
                if(possibleChild.parents.contains(person.name())) {
                    person.addChild(possibleChild.person);
                }
            }
        }
    }
}
