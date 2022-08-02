package org.acme.getting.started;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.getting.started.db.model.Person;
import org.acme.getting.started.db.model.dto.PersonDTO;
import org.acme.getting.started.db.model.dto.PersonFullDTO;
import org.acme.getting.started.service.PersonService;

@Path("/person")
public class PersonResource {

    @Inject
    PersonService service;

    @PostConstruct
    void init() {
        this.service.init();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public List<PersonDTO> list(final String name) {
        return this.service.findList();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public List<Person> all(final String name) {
        return this.service.findAll();
    }

    @POST
    @Path("/add")
    public PersonFullDTO add(final PersonFullDTO person) {
        return this.service.add(person);
    }

    @PUT
    @Path("/update")
    public PersonFullDTO update(final PersonFullDTO person) {
        return this.service.update(person);
    }


}
