package org.acme.getting.started.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.acme.getting.started.db.model.Person;
import org.acme.getting.started.db.model.dto.PersonAliasDTO;
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


    @Test
    void findByNameTest() {
        this.service.init();
        List<Person> persons = this.service.findByNamePattern("doe");

        System.out.println(persons.get(0).aliases.iterator().next().person.id);
    }

    @Test
    void finalAllAliasTest() {

        this.service.init();
        List<PersonAliasDTO> allAlias = this.service.findAllAlias();

        allAlias.forEach(a -> System.out.println(a.personId));

    }

}
