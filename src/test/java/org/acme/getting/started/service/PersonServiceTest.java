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
    @Transactional
    void updateName() {

        Person person = Person.findById(1L);
        person.name = "NEW " + person.name;

        person.persistAndFlush();
    }

    @Test
    void findPersonList() {
        System.out.println(this.service.findListWithStrategy(1L));
    }

    @Test
    void findAll() {
        System.out.println(this.service.findAll());
    }

    @Test
    void findByNameTest() {
        List<Person> persons = this.service.findByNamePattern("doe");

        System.out.println(persons.get(0).aliases.iterator().next().person.id);
    }

    @Test
    void finalAllAliasTest() {
        List<PersonAliasDTO> allAlias = this.service.findAllAlias();

        allAlias.forEach(a -> System.out.println(a.personId));

    }

    @Test
    void testEnum() {
//
//        for (StrategyEnum e : StrategyEnum.values()) {
//
//            System.out.println(e.name()
//                    + " : " + e.getType()
//                    + " / " + e.getType().getType()
//                    + " / " + e.getType().getRawType()
//                    );
//        }

    }

}
