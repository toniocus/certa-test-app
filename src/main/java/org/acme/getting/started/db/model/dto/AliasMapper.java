package org.acme.getting.started.db.model.dto;

import org.acme.getting.started.db.model.PersonAlias;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface AliasMapper {

    PersonAliasDTO  fromPersonAlias(PersonAlias alias);

    @Mapping(source = "id", target = "id", ignore = true)
    PersonAlias     toNewAlias(PersonAliasDTO dto);

    @Mapping(source = "id", target = "id", ignore = true)
    void updateAlias(@MappingTarget PersonAlias alias, PersonAliasDTO dto);
}
