import api.Person;
import util.Comparator;

import java.util.ArrayList;

public class Main {
    public static void main(String... args) {
        Comparator<Person> personComparator = Comparator
                .comparing(Person::getFirstName)
                .thenCompare(Person::getLastName)
                .thenCompare(Person::getAge);
        Person person1 = new Person("Peter", "Parker", 23);
        Person person2 = new Person("John", "Smith", 24);
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.sort(personComparator);
        System.out.println(persons);
    }
}
