package org.acme.getting.started;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    GreetingService service;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public String greeting(final String name) {
        return this.service.greeting(name);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/world/{name}")
    public String world(final String name) {
        return String.format("Hello, the world is waiting for %s to be ready.", name);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
}
