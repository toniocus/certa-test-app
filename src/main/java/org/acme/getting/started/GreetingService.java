package org.acme.getting.started;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    public String greeting(final String name) {
        return String.format("Heroku is greeting %s with a beatiful kiss.", name);
    }

}
