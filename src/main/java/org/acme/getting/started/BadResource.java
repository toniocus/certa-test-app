package org.acme.getting.started;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/bad")
public class BadResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/3")
    public String two() {
        return "We are Bad Boys VERSION II.";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/boys")
    public String boys() {
        return "We are the WORST Group of Boys that never existed.";
    }


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "I'm really a very very BAD BOY.";
    }
}
