package ee.tptlive.testid.mockingdemo.rest.rest;

import ee.tptlive.testid.mockingdemo.rest.model.Person;
import ee.tptlive.testid.mockingdemo.rest.service.PersonService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@ApplicationScoped
@Path("persons")
public class PersonEndpoint {

    @Inject
    private PersonService personService;

    @GET
    @Produces(APPLICATION_JSON)
    public List<Person> getAll(
            @QueryParam("sex") Boolean sex,
            @QueryParam("name") String name
    ) {
        Stream<Person> persons = personService.getAll().stream();
        if (sex != null) {
            persons = persons.filter(person -> sex.equals(person.isSex()));
        }
        if (name != null) {
            persons = persons.filter(person ->
                    person.getName().toLowerCase().contains(name.toLowerCase()));
        }
        return persons.collect(toList());
    }

}
