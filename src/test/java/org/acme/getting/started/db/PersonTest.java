package org.acme.getting.started.db;

import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;


@QuarkusTest
class PersonTest extends Assertions {

    @Inject
    PersonService service;

    @Test
    @Transactional
    void addPerson() {

        Person p = new Person();
        p.birth = LocalDate.now();
        p.name = "John Doe";
        p.status = PersonStatus.ALIVE;

        p.persistAndFlush();

        List<Person> list = Person.list("name", "John Doe");

        System.out.println(list);

    }

    @Test
    @Transactional
    void updatePerson() {

        Person p = new Person();
        p.birth = LocalDate.now();
        p.name = "John Doe";
        p.status = PersonStatus.ALIVE;
        p.addAlias(PersonAliasType.DNI, "1111");
        p.addAlias(PersonAliasType.EMAIL, "me@family.com");
        p.persistAndFlush();

        p.getEntityManager().clear();
        List<Person> list = Person.list("name", "John Doe");

        System.out.println(list);
    }

    @Test
    void serviceTest() {

        System.out.println(this.service.findByNamePattern("doe"));
    }
}
