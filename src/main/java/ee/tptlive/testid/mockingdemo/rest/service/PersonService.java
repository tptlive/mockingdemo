package ee.tptlive.testid.mockingdemo.rest.service;

import ee.tptlive.testid.mockingdemo.rest.dao.PersonDao;
import ee.tptlive.testid.mockingdemo.rest.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class PersonService {

    @Inject
    private PersonDao personDao;

    public List<Person> getAll() {
        return personDao.findAll();
    }

}
