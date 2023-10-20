import java.util.Objects;

public class Person {

    private final String name;
    private final String surname;
    private final String cnp;

    public Person(String name, String surname, String cnp) {
        if( name == null ||  "".equals(name.trim()) ){
            throw new IllegalArgumentException("null or empty name detected: " + name);
        }

        if( surname == null ||  "".equals(surname.trim()) ){
            throw new IllegalArgumentException("null or empty name detected: " + surname);
        }

        if( cnp == null ||  "".equals(cnp.trim()) ){
            throw new IllegalArgumentException("null or empty name detected: " + cnp);
        }

        this.name = name;
        this.surname = surname;
        this.cnp = cnp;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCnp() {
        return cnp;
    }

    @Override
    public String toString() {
        return "name='" + name + ", surname='" + surname + ", cnp='" + cnp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return Objects.equals(cnp, person.cnp);
    }

    @Override
    public int hashCode() {
        return cnp != null ? cnp.hashCode() : 0;
    }
}
