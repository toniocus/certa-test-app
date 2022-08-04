package org.acme.getting.started.db.model.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.JsonNode;

import org.acme.getting.started.db.model.PersonStatus;


public class PersonDTO {

    public Long id;
    public String name;
    public LocalDate birth;
    public PersonStatus status;
    public JsonNode properties;
}
