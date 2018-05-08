package ee.tptlive.testid.mockingdemo.rest.rest;

import ee.tptlive.testid.mockingdemo.rest.model.Person;
import ee.tptlive.testid.mockingdemo.rest.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.inject.Inject;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PersonEndpointTest {

    @Mock
    private PersonService personService;

    @InjectMocks
    private PersonEndpoint personEndpoint;

    @Test
    public void getAll_ReturnsAllFromDao_IfSexIsNull() {
        // given
        when(personService.getAll()).thenReturn(asList(
                new Person(10, "Hector", 50, false),
                new Person(11, "Pavel", 11, false),
                new Person(12, "Kertu", 25, true),
                new Person(13, "Jelena", 32, true)
        ));
        Boolean sex = null;
        String name = null;

        // when
        List<Person> result = personEndpoint.getAll(sex, name);

        // then
        assertEquals(4, result.size());
        assertEquals("Hector", result.get(0).getName());
        assertEquals("Pavel", result.get(1).getName());
        assertEquals("Kertu", result.get(2).getName());
        assertEquals("Jelena", result.get(3).getName());
    }

    @Test
    public void getAll_ReturnsAllMenFromDao_IfSexIsFalse() {
        // given
        when(personService.getAll()).thenReturn(asList(
                new Person(10, "Hector", 50, false),
                new Person(11, "Pavel", 11, false),
                new Person(12, "Kertu", 25, true),
                new Person(13, "Jelena", 32, true)
        ));
        Boolean sex = false;
        String name = null;

        // when
        List<Person> result = personEndpoint.getAll(sex, name);

        // then
        assertEquals(2, result.size());
        assertEquals("Hector", result.get(0).getName());
        assertEquals("Pavel", result.get(1).getName());
    }

}