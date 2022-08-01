package org.acme.getting.started.db.model.dto;

import org.acme.getting.started.db.model.PersonAliasType;

public class PersonAliasDTO {
    public Long id;
    public PersonAliasType type;
    public String alias;
    public Long personId;
}
