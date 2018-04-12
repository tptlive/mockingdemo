package ee.tptlive.testid.mockingdemo.rest.service;

import ee.tptlive.testid.mockingdemo.rest.dao.PersonDao;
import ee.tptlive.testid.mockingdemo.rest.model.Person;

import javax.inject.Inject;
import java.util.List;

public class PersonService {

    @Inject
    private PersonDao personDao;

    public List<Person> getAll() {
        return personDao.findAll();
    }

}
