package org.acme.getting.started.db;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity(name = "person_alias")
@Table(indexes = {
        @Index(name = "person_alias_unq_idx", columnList = "alias, type, id", unique = true)
})
public class PersonAlias extends CertaEntity {

    public PersonAliasType type;
    public String alias;
    @Column(name = "person_id")
    public Long personId;

    public PersonAlias() {
    }

    public PersonAlias(final PersonAliasType type, final String value) {
        this.type = type;
        this.alias = value;
    }


    @Override
    public int hashCode() {
        return Objects.hash(this.alias, this.type);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PersonAlias)) {
            return false;
        }
        PersonAlias other = (PersonAlias) obj;
        return Objects.equals(this.alias, other.alias) && this.type == other.type;
    }


    @Override
    public String toString() {
        return String.format("PersonAlias [type=%s, alias=%s, personId=%s]", this.type, this.alias, this.personId);
    }


}
