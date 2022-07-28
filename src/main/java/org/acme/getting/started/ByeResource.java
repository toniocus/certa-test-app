package org.acme.getting.started;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * The Class ByeResource.
 */
@Path("/bye")
public class ByeResource {


    /**
     * Hello.
     *
     * @return the string
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Good bye dear friend, have a good day";
    }
}
