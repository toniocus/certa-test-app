package org.acme.getting.started.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.acme.getting.started.db.model.Person;
import org.acme.getting.started.db.model.PersonAliasType;
import org.acme.getting.started.db.model.PersonStatus;
import org.acme.getting.started.db.model.dto.PersonDTO;
import org.acme.getting.started.db.model.dto.PersonFullDTO;
import org.acme.getting.started.db.model.dto.PersonMapper;

@ApplicationScoped
public class PersonService {

    @Inject
    private PersonMapper personMapper;

    @Transactional
    public void init() {

        if (Person.findById(1L) == null) {

            Person p = new Person();
            p.birth = LocalDate.now().minus(30L, ChronoUnit.YEARS);
            p.name = "John Doe";
            p.status = PersonStatus.ALIVE;
            p.addAlias(PersonAliasType.DNI, "1111");
            p.addAlias(PersonAliasType.EMAIL, "me@family.com");
            p.persistAndFlush();

            Person p1 = new Person();
            p1.birth = LocalDate.now().minus(80L, ChronoUnit.YEARS);
            p1.name = "John Senior Doe";
            p1.status = PersonStatus.DEATH;
            p1.addAlias(PersonAliasType.DNI, "9999");
            p1.addAlias(PersonAliasType.EMAIL, "granpa@family.com");
            p1.persistAndFlush();
        }

    }

    @Transactional
    public PersonFullDTO add(final PersonFullDTO dto) {

        Person person = this.personMapper.toNewPersonFull(dto);

//        person.id = null;
        person.aliases.forEach(d -> d.id = null);
        person.persistAndFlush();

        return this.personMapper.fromPersonFull(person);
    }

    @Transactional
    public List<PersonDTO> findList() {
        return this.personMapper.fromPersons(Person.findAll().list());
    }

    @Transactional
    public List<Person>  findAll() {

        EntityManager em = Person.getEntityManager();

        EntityGraph<Person> graph = em.createEntityGraph(Person.class);
        graph.addAttributeNodes("aliases");

        String sql = "from Person";

        return em.createQuery(sql, Person.class)
            .setHint("javax.persistence.loadgraph", graph)
            .getResultList();
    }

    @Transactional
    public List<Person> findByNamePattern2(final String pattern) {

        List<Person> persons = Person.getEntityManager().createNamedQuery("byName", Person.class)
                .setParameter("pattern", "%" + pattern + "%").getResultList();

        persons.forEach(p -> {
            p.aliases.size();
        });
        return persons;
    }

    @Transactional
    public List<Person>  findByNamePattern(final String pattern) {

        EntityManager em = Person.getEntityManager();

        EntityGraph<Person> graph = em.createEntityGraph(Person.class);
        graph.addAttributeNodes("aliases");

        //String sql = "from Person where lower(name) like :pattern";
        String sql = "from Person where pg_ilike(name, :pattern) = true";

        return em.createQuery(sql, Person.class)
            .setParameter("pattern", "%" + pattern.toLowerCase() + "%")
            .setHint("javax.persistence.loadgraph", graph)
            .getResultList();
    }
}
