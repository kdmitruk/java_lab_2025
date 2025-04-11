public class AmbiguousPersonException extends Exception {
    public AmbiguousPersonException(Person existingPerson, Person newPerson) {
        super(String.format("Osoba %s nazywa sie tak samo jak już istniejąca osoba %s.", newPerson, existingPerson));

    }
}
