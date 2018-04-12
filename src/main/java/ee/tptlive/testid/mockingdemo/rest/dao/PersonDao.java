package ee.tptlive.testid.mockingdemo.rest.dao;

import ee.tptlive.testid.mockingdemo.rest.model.Person;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@ApplicationScoped
public class PersonDao {

    private List<Person> database = asList(
            new Person(1, "John", 30, false),
            new Person(2, "Dacota", 19, true),
            new Person(3, "Stephen", 34, false),
            new Person(4, "Jelena", 70, true),
            new Person(5, "Elizabeth", 99, true)
    );

    public List<Person> findAll() {
        return new ArrayList<>(database);
    }

}
