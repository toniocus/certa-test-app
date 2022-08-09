package org.acme.getting.started.db.model.dto;

import java.util.List;

import org.acme.getting.started.db.model.Person;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI, uses = { AliasMapper.class} )
public interface PersonMapper {


    PersonNameDTO   fromPersonName(Person person);
    PersonFullDTO   fromPersonFull(Person person);

    @Mapping(source = "id", target = "id", ignore = true)
    Person          toNewPerson(PersonFullDTO dto);

    void update(@MappingTarget Person person, PersonFullDTO dto);
    void updateName(@MappingTarget Person person, PersonNameDTO dto);

    PersonDTO  fromPerson(Person person);

    @IterableMapping(elementTargetType = PersonDTO.class)
    List<PersonDTO>  fromPersons(List<Person> list);

    @IterableMapping(elementTargetType = PersonFullDTO.class)
    List<PersonFullDTO>  fromPersonsFull(List<Person> list);

}
