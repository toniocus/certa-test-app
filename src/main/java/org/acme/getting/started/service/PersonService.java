package org.acme.getting.started.service;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.acme.getting.started.db.model.Person;
import org.acme.getting.started.db.model.PersonAlias;
import org.acme.getting.started.db.model.dto.AliasMapper;
import org.acme.getting.started.db.model.dto.PersonAliasDTO;
import org.acme.getting.started.db.model.dto.PersonDTO;
import org.acme.getting.started.db.model.dto.PersonFullDTO;
import org.acme.getting.started.db.model.dto.PersonMapper;
import org.acme.getting.started.strategy.MyStrategyBase;
import org.acme.getting.started.strategy.StrategyContext;
import org.acme.getting.started.strategy.StrategyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class PersonService {

    private static final Logger log = LoggerFactory.getLogger(PersonService.class);

    @Inject
    private PersonMapper personMapper;

    @Inject
    AliasMapper aliasMapper;

    @Inject
    StrategyFactory factory;

    @Transactional
    public PersonFullDTO add(final PersonFullDTO dto) {

        Person person = this.personMapper.toNewPerson(dto);

//        person.id = null;
//        person.aliases.forEach(d -> d.id = null);
//        person.persistAndFlush();

        person.persistAndFlush();
        return this.personMapper.fromPersonFull(person);
    }

    @Transactional
    public PersonFullDTO update(final PersonFullDTO dto) {

        Person person = (Person) Person.findByIdOptional(dto.id)
                .orElseThrow(() -> new RuntimeException("No able to find Person with Id: " + dto.id));

        Set<PersonAlias> modifiedAlias = this.aliasMapper.updatedPersonAlias(dto.aliases, person.aliases);

        this.personMapper.update(person, dto);
        person.aliases = modifiedAlias;
        person.aliases.forEach(a -> a.person = person);

        person.persistAndFlush();
        return this.personMapper.fromPersonFull(person);
    }


    @Transactional
    public List<PersonDTO> findListWithStrategy(final Long type) {

        log.info("Service findListWithStrategy...");

        log.info("Obtaining strategy.....");
        MyStrategyBase strategy = this.factory.createStrategy(type, new StrategyContext());
        log.info("Strategy obtained.");

        strategy.generateRequest();

        List<PersonDTO> list = this.personMapper.fromPersons(Person.findAll().list());
        list.forEach(p ->  p.name = strategy.getIdString());

        return list;
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
    public List<PersonAliasDTO> findAllAlias() {
        return this.aliasMapper.fromAliases(PersonAlias.findAll().list());
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
