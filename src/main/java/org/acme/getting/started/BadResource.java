package org.acme.getting.started;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/bad")
public class BadResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/boys")
    public String boys() {
        return "We are really very very BAD GROUP OF BOYS.";
    }


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "I'm really a very very BAD BOY.";
    }
}
