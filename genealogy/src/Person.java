import java.time.LocalDate;

public class Person {
    private String firstName,lastName;
    private LocalDate birthDay;

    public Person(String firstName, String lastName, LocalDate birthDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
    }
}
