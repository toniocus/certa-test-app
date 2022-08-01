package org.acme.getting.started.db.model.dto;

import java.util.List;
import java.util.Set;

import org.acme.getting.started.db.model.Person;
import org.acme.getting.started.db.model.PersonAlias;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface PersonMapper {

    //@Mapping(source = "aliases", ignore = true, target = "")
    PersonDTO  fromPerson(Person person);
    Person     toPerson(PersonDTO dto);

    @IterableMapping(elementTargetType = PersonDTO.class)
    List<PersonDTO>  fromPersons(List<Person> list);
    List<Person>     toPersons(List<PersonDTO> list);

    PersonFullDTO    fromPersonFull(Person person);

    @Named("existingPerson")
    Person           toPersonFull(PersonFullDTO dto);

    @Mapping(target = "id", source = "id", ignore = true)
    Person           toNewPersonFull(PersonFullDTO dto);

    @IterableMapping(elementTargetType = PersonFullDTO.class)
    List<PersonFullDTO>  fromPersonsFull(List<Person> list);

    @IterableMapping(elementTargetType = Person.class, qualifiedByName = "existingPerson")
    List<Person>         toPersonsFull(List<PersonFullDTO> list);

    PersonAliasDTO  fromPersonAlias(PersonAlias alias);
    PersonAlias     toPersonAlias(PersonAliasDTO dto);

    Set<PersonAliasDTO>  fromAliases(Set<PersonAlias> list);
    Set<PersonAlias>  toAliases(Set<PersonAliasDTO> list);
}
