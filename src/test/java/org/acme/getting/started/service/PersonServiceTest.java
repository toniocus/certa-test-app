package org.acme.getting.started.service;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class PersonServiceTest {

    @Inject
    PersonService service;

    @Test
    @Transactional
    void updatePerson() {
        System.out.println(this.service.findList());
    }

}
