package org.acme.getting.started.db.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "person_alias")
@Table(indexes = {
        @Index(name = "person_alias_unq_idx", columnList = "alias, type, id", unique = true)
})
public class PersonAlias extends CertaEntity {

    @Enumerated(EnumType.STRING)
    public PersonAliasType type;
    public String alias;

//    @Column(name = "person_id")
//    public Long personId;

    @ManyToOne(fetch = FetchType.LAZY)
    public Person person;

    public PersonAlias() {
    }

    public PersonAlias(final Person person, final PersonAliasType type, final String value) {
        this.type = type;
        this.alias = value;
        this.person = person;
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
        return String.format("PersonAlias [type=%s, alias=%s, personId=%s]", this.type, this.alias, this.person.id);
    }


}
