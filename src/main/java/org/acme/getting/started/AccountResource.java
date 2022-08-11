package org.acme.getting.started;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.getting.started.db.model.SfAccount;
import org.acme.getting.started.db.model.dto.AccountUpdateDTO;
import org.acme.getting.started.service.AccountService;
import org.jboss.resteasy.reactive.RestPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/acc")
public class AccountResource {

    private static final Logger log = LoggerFactory.getLogger(AccountResource.class);

    @Inject
    AccountService service;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id/{id}")
    public SfAccount listComplex(@RestPath final Integer id) {

        log.info("Calling listPerson....");
        return this.service.accountById(id);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id")
    public SfAccount update(final AccountUpdateDTO dto) {
        return this.service.updateAccountBasics(dto);
    }


}
