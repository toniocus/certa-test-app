package org.acme.getting.started.db.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(indexes = {
        @Index(name = "person_name_idx", columnList = "name")
})
@NamedNativeQueries({
    @NamedNativeQuery(name = "byName"
            , query = "select * from person where name ILIKE :pattern"
            , resultClass = Person.class)
    , @NamedNativeQuery(name = "byName2", query = "name ILIKE ?1")
})
public class Person extends CertaEntity {


    public String name;
    public LocalDate birth;

    @Enumerated(EnumType.STRING)
    public PersonStatus status;

    @OneToMany(orphanRemoval = true, cascade = {CascadeType.ALL})
    @JoinColumn(name = "person_id"
            , foreignKey = @ForeignKey(name = "person_alias_person_fk")
            )
    public Set<PersonAlias> aliases = new HashSet<>();


    public boolean addAlias(final PersonAliasType type, final String value) {
        return this.aliases.add(new PersonAlias(this, type, value));
    }

    @Override
    public String toString() {
        final int maxLen = 5;
        return String.format("Person [id=%d, name=%s, birth=%s, status=%s, aliases=%s]", this.id, this.name, this.birth,
                this.status, this.aliases != null ? toString(this.aliases, maxLen) : null);
    }

    private String toString(final Collection<?> collection, final int maxLen) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        int i = 0;
        for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
            if (i > 0) {
                builder.append(", ");
            }
            builder.append(iterator.next());
        }
        builder.append("]");
        return builder.toString();
    }

}
