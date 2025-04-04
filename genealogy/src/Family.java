import java.util.*;

public class Family {
    private Map<String, List<Person>> people = new HashMap<>();

    public void add(Person... people){
        for (Person person : people){
            if(this.people.containsKey(person.name())){
                List<Person> peopleWithSameName = this.people.get(person.name());
                if(!peopleWithSameName.contains(person)){
                    peopleWithSameName.add(person);
                }
            } else {
                List<Person> peopleWithSameName = new ArrayList<>();
                peopleWithSameName.add(person);
                this.people.put(person.name(), peopleWithSameName);
            }
        }
    }
    public Person[] get(String name){
        List<Person> peopleWithSameName = people.get(name);
        if(peopleWithSameName==null)
            return null;
        Person[] result = new Person[peopleWithSameName.size()];
        peopleWithSameName.toArray(result);
        Arrays.sort(result);
        return result;
    }
}
