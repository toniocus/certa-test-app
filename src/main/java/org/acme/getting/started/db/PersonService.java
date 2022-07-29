package org.acme.getting.started.db;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class PersonService {

    @PostConstruct
    @Transactional
    public void init() {

        if (Person.findById(1L) == null) {

            Person p = new Person();
            p.birth = LocalDate.now().minus(30L, ChronoUnit.YEARS);
            p.name = "John Doe";
            p.status = PersonStatus.ALIVE;
            p.addAlias(PersonAliasType.DNI, "1111");
            p.addAlias(PersonAliasType.EMAIL, "me@family.com");

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
        graph.addAttributeNodes("name", "birth", "aliases");

        return em.createQuery("from Person where lower(name) like :pattern", Person.class)
            .setParameter("pattern", "%" + pattern.toLowerCase() + "%")
            .setHint("javax.persistence.fetchgraph", graph)
            .getResultList();
    }
}
