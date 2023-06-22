package com.nkxgen.spring.orm.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t4_functional_units")
public class FunctionalUnit {
    @EmbeddedId
    private FUnitId id;

    @Column(name = "funit_desc")
    private String description;

    public FunctionalUnit() {
        // Default constructor required by JPA
    }

    public FunctionalUnit(FUnitId id, String description) {
        this.id = id;
        this.description = description;
    }

    public FUnitId getId() {
        return id;
    }

    public void setId(FUnitId id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Other methods
}
