public class NegativeLifespanException extends Exception{
    public NegativeLifespanException(Person person) {
        super(String.format("Osoba %s urodziła sie w %s który jest późniejszy niż %s.",person.name(),person.getBirthDate(),person.getDeathDate()));

    }
}
