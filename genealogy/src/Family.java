import java.util.HashMap;
import java.util.Map;

public class Family {
    private Map<String, Person> people = new HashMap<>();

    public void add(Person person){
        people.put(person.name(), person);
    }
    public Person get(String name){
        return people.get(name);
    }
}
