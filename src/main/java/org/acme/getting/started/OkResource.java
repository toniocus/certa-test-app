package org.acme.getting.started;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ok")
public class OkResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "HI This is the OK Service";
    }
}
