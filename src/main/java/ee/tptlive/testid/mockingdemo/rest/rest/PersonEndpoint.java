package ee.tptlive.testid.mockingdemo.rest.rest;

import ee.tptlive.testid.mockingdemo.rest.model.Person;
import ee.tptlive.testid.mockingdemo.rest.service.PersonService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@ApplicationScoped
@Path("persons")
public class PersonEndpoint {

    @Inject
    private PersonService personService;

    @GET
    @Produces(APPLICATION_JSON)
    public List<Person> getAll() {
        return personService.getAll();
    }

}
