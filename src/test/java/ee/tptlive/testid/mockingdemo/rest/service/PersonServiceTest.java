package ee.tptlive.testid.mockingdemo.rest.service;

import ee.tptlive.testid.mockingdemo.rest.dao.PersonDao;
import ee.tptlive.testid.mockingdemo.rest.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    @Mock
    private PersonDao personDao;

    @InjectMocks
    private PersonService personService;

    @Test
    public void getAll_ReturnsAllFromDao_IfDaoFindsSomething() {
        // given
        when(personDao.findAll()).thenReturn(asList(
                new Person(10, "Hector", 50, false),
                new Person(11, "Pavel", 11, false)
        ));

        // when
        List<Person> result = personService.getAll();

        // then
        assertEquals(2, result.size());
        assertEquals("Hector", result.get(0).getName());
        assertEquals("Pavel", result.get(1).getName());
    }

}