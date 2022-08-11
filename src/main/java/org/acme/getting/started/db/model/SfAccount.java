package org.acme.getting.started.db.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;


@Entity
@Table(name = "account", schema = "salesforce")
public class SfAccount extends PanacheEntityBase {

    @Id
    public Integer id;


    public String name;
    public String description;
    public String phone;
    public String website;
    public String type;
    public LocalDateTime createdDate;
    public LocalDateTime systemModStamp;
    public boolean isDeleted;

    @Column(name = "active__c")
    public String active;

    @Column(updatable = false)
    private String sfid;

    @Column(name = "_hc_lastop", updatable = false)
    @JsonIgnore
    private String lastOperation;

    @Column(name = "_hc_err", updatable = false)
    @JsonIgnore
    private String lastError;

    public String getSfid() {
        return this.sfid;
    }

    public String getLastOperation() {
        return this.lastOperation;
    }

    public String getLastError() {
        return this.lastError;
    }
}
