package org.acme.getting.started.db.model.dto;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.acme.getting.started.db.model.PersonAlias;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface AliasMapper {

    @Mapping(source = "person.id", target = "personId")
    PersonAliasDTO  fromPersonAlias(PersonAlias alias);

    @Mapping(source = "id", target = "id", ignore = true)
    PersonAlias     toNewAlias(PersonAliasDTO dto);

    @Named("updateAlias")
    void updateAlias(@MappingTarget PersonAlias alias, PersonAliasDTO dto);

    @IterableMapping(elementTargetType = PersonAliasDTO.class)
    List<PersonAliasDTO>  fromAliases(List<PersonAlias> list);

    @IterableMapping(elementTargetType = PersonAlias.class)
    Set<PersonAlias>  fromAliasesDTO(Set<PersonAliasDTO> list);

    default Set<PersonAlias> updatedPersonAlias(final Set<PersonAliasDTO> modifiedDTO, final Set<PersonAlias>  existent) {
        Set<PersonAlias> modified = fromAliasesDTO(modifiedDTO);
        existent.addAll(modified);

        for (Iterator<PersonAlias> it = existent.iterator(); it.hasNext();) {
            if (!modified.contains(it.next())) {
                it.remove();
            }
        }

        return existent;
    }

}
