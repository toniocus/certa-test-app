package org.acme.getting.started.db.model.dto;

import java.util.List;

import org.acme.getting.started.db.model.PersonAlias;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface AliasMapper {

    @Mapping(source = "person.id", target = "personId")
    PersonAliasDTO  fromPersonAlias(PersonAlias alias);

    @Mapping(source = "id", target = "id", ignore = true)
    PersonAlias     toNewAlias(PersonAliasDTO dto);

    void updateAlias(@MappingTarget PersonAlias alias, PersonAliasDTO dto);

    @IterableMapping(elementTargetType = PersonAliasDTO.class)
    List<PersonAliasDTO>  fromAliases(List<PersonAlias> list);

}
